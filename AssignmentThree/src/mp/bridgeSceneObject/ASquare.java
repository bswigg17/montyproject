package mp.bridgeSceneObject;

import java.beans.PropertyChangeEvent;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN) 
public class ASquare extends ABoundedShape implements Square {
	
	static final int SQUARE_WIDTH=300, SQUARE_HEIGHT=75; 
	
	public ASquare() {
		super(SQUARE_WIDTH, SQUARE_HEIGHT); 
	}
	public ASquare(int width, int height) {
		super(width, height);  
	}
	
	public ASquare(int width, int height, int x, int y) {
		super(width, height, x, y); 
	}
	
	
}

