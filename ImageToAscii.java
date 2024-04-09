package imageToAscii;

public class ImageToAscii {
    int scale;
    String imagePath;
    ImageProcessor imageProcess;

    public ImageToAscii(String imagePath, int scale) {
        this.scale = scale;
        this.imagePath = imagePath;
        imageProcess = new ImageProcessor(imagePath);
    }

    public String convertImageToAscii(){
        StringBuilder asciiArt = new StringBuilder();
        try {
            int[][] data = imageProcess.getMatrixAfterProcessing(scale);
            int height = data.length;
            int width = data[0].length;
            for(int i = 0; i < height; i+=scale*2){
                for(int j = 0; j < width; j+=scale){
                    char ch = getAsciiCharacter(data[i][j]);
                    asciiArt.append(ch);
                }
                asciiArt.append(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return asciiArt.toString();
    }

    private char getAsciiCharacter(int i) {
        // TODO Auto-generated method stub
        char[] asciiCharacters = {' ', '.', ',', '-', '~', '+', '=', '@', '_'};
        int index = (int) ((asciiCharacters.length - 1) * (i / 255.0));
        return asciiCharacters[Math.min(index, asciiCharacters.length - 1)];
    }
}
