package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class DoorObject extends ParentObject{
	
	public DoorObject() {
		objectName = "Door";
		
		try {
			objectSprite = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
			
	}

}
