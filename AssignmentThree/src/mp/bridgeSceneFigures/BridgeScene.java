package mp.bridgeSceneFigures;

import tags301.Comp301Tags;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"Arthur",
	"Galahad",
	"Guard",
	"Lancelot",
	"Robin",
})
public interface BridgeScene {
	
	static final int X_POS_ONE=100, X_POS_TWO=200, X_POS_THREE=700, X_POS_FOUR=400, X_POS_FIVE=500,
			Y_POS_ONE=500, Y_POS_TWO=700;  
	
	public void reset(); 
	public Avatar getArthur(); 
	public Avatar getGalahad(); 
	public Avatar getGuard(); 
	public Avatar getLancelot(); 
	public Avatar getRobin(); 
}
