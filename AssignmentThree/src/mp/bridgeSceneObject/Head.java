package mp.bridgeSceneObject;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public interface Head extends Square {
 
	static final String NAME="images/arthur.jpg";

	
    public String getImageFileName();

}

