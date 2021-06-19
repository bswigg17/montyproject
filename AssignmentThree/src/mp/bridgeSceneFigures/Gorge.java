package mp.bridgeSceneFigures;

import mp.bridgeSceneObject.Line;
import mp.bridgeSceneObject.Square;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"LeftLine",
	"RightLine",
	"ASquare", 
})
public interface Gorge extends TwoLines {

	Line getLeftLine();
	Line getRightLine();
	Square getASquare();
}
