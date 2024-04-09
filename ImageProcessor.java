package imageToAscii;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageProcessor {
    private ImageType imageType;
    private String imagePath;

    public ImageProcessor(String imagePath) {
        this.imagePath = imagePath;
        this.imageType = new ImageType(imagePath);
    }

    public int[][] getMatrixAfterProcessing(int scale) {
        BufferedImage image = getImage(imagePath);
        return getIntensityMatrix(image, scale);
    }

    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;
        try {
            boolean isValid = imageType.isValidImage();
            if(isValid) {
                image = ImageIO.read(new File(imagePath));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public int[][] getIntensityMatrix(BufferedImage image, int scale){
        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();
        // System.out.println("image height = " + imageHeight + " image width = " + imageWidth);
        int intensityMatrix[][] = new int[imageHeight+1][imageWidth+1];
        for(int i = 0; i < imageWidth; i++){
            for(int j = 0; j < imageHeight; j++) {
                intensityMatrix[j][i] = calculateIntensity(image, i, j, scale);
            }
        }
        return intensityMatrix;
    }

    public int calculateIntensity(BufferedImage image, int i, int j, int scale) {
        int totalIntensity = 0;
        int totalPixels = 0;
        for(int x=i; x<Math.min(i+scale*2, image.getWidth()); x++){
            for(int y=j; y<Math.min(j+scale, image.getHeight()); y++){
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;
                int intensity = red/3 + green/3 + blue/3;
                totalIntensity += intensity;
                totalPixels++;
            }
        }
        return totalPixels == 0 ? 0 : totalIntensity/totalPixels;
    }
}
