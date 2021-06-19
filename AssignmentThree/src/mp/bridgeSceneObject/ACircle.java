package mp.bridgeSceneObject;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
public class ACircle extends ABoundedShape implements Circle {
	
	public ACircle(int width, int height) {
		super(width, height); 
	}
	
	public ACircle(int width, int height, int x, int y) {
		super(width, height, x, y); 
	}
	
}
