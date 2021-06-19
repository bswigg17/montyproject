package mp.bridgeSceneObject;

import tags301.Comp301Tags;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags(Comp301Tags.BOUNDED_SHAPE)
public interface BoundedShape extends Deminsions, PropertyListenerRegisterer {
	 
	void setWidth(int val); 
	void setHeight(int val); 
	
}

