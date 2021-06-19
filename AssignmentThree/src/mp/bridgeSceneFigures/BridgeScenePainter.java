package mp.bridgeSceneFigures;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.OBSERVABLE_BRIDGE_SCENE_PAINTER)
public interface BridgeScenePainter {

	public void addPaintListener(PaintListener aListener); 
	
}
