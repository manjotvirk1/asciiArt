package imageToAscii;

public class ImageType {
    private static String imagePath;

    public ImageType(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isValidImage() {
        String extension = null;
        try{
            int extensionStartIndex = imagePath.lastIndexOf('.');
            if(extensionStartIndex > 0 && extensionStartIndex < imagePath.length() - 1) {
                extension = imagePath.substring(extensionStartIndex+1);
            }
            if(isValidExtension(extension.toLowerCase()))return true;
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isValidExtension(String extension) {
        String JPG = "jpg";
        String PNG = "png";
        String JPEG = "jpeg";

        if(extension.equalsIgnoreCase(JPG) || extension.equalsIgnoreCase(PNG) || extension.equalsIgnoreCase(JPEG))
            return true;
        return false;
    }
}
