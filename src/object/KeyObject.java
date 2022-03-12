package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class KeyObject extends ParentObject {

	
	public KeyObject() {
		objectName = "Key";
		
		try {
			objectSprite = ImageIO.read(getClass().getResourceAsStream("/objects/batarang.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		collision=true;
			
	}
	
	
}
