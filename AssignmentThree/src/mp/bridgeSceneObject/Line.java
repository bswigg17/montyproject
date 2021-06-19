package mp.bridgeSceneObject;

import mp.bridgeSceneFigures.Move;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags(Comp301Tags.ROTATING_LINE)
public interface Line extends MutablePoint, Move {

	static final int INITIAL_X = 100, INITIAL_Y = 100;
	
	public void rotate(int val);
	public void setAngle(double val); 
	int getWidth();
	int getHeight(); 
}

 