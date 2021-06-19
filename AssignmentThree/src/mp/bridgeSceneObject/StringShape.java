package mp.bridgeSceneObject;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
public interface StringShape extends Locatable {

	static final String STRING = ""; 
	
	String getText();
	void setText(String val); 
	
	
}

