package imageToAscii;

public class printAsciiArt {
    public static void main(String[] args) {
        // String imagePath = "images/download.jpg";     // path to image
        String imagePath = "C:\\Mj\\video\\IMG-20200610-WA0029_copy.jpg";
        ImageToAscii imageAscii = new ImageToAscii(imagePath, 2);
        String response = imageAscii.convertImageToAscii();
        System.out.println(response);
    }
}
