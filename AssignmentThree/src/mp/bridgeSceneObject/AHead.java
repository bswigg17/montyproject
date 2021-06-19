package mp.bridgeSceneObject;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon; 

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public class AHead extends ASquare implements Head {
	
	
	static final String NAME="images/arthur.jpg"; 
	protected String imageFileName=NAME;
	
	public AHead(String anImageFileName) {
		imageFileName = anImageFileName;
		Icon icon = new ImageIcon(imageFileName);
		this.height = icon.getIconHeight();	
		this.width = icon.getIconWidth(); 
	}

	@Override
    public String getImageFileName() {return imageFileName;}  
}

