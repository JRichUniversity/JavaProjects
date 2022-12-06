package ChristmasProject;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * @author Jakob Reichle
 *
 * Einreichung für Weihnachtskontest 2022 - Programmieren I
 */
public class Lumenaer {

    public static void main(String args[]){
        gifReader("src/ChristmasProject/christmas.gif");
    }

    static void gifReader(String path){
        try {
            ImageReader reader = ImageIO.getImageReadersByFormatName("gif").next();
            File gif = new File(path);
            reader.setInput(ImageIO.createImageInputStream(gif));
            for(int i = 0, count = reader.getNumImages(true); i < count; i++){
                BufferedImage image = reader.read(i);
                ImageIO.write(image, "PNG", new File("output" + i + ".png"));
            }
        }
        catch (IOException ex){
            //Error has occurred
        }

    }

}
