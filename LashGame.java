package gameTetris;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JWindow;

public class LashGame extends JWindow {
   public Image LoadImage(String image){ 
		try{ 
			File file = new File(image);
			InputStream is = new FileInputStream(file);
			Image im = ImageIO.read(new BufferedInputStream(is));
			return im;
		}
    catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
