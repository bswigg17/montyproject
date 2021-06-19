package mp.bridgeSceneObject;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags(Comp301Tags.LOCATABLE)
@PropertyNames({
	"X",
	"Y", 
})
@EditablePropertyNames({
	"X",
	"Y", 
})
public interface Locatable extends PropertyListenerRegisterer {
	
	static final int X=100, Y=100;
	
	int getX();
	int getY();
	public void setX(int x); 
	public void setY(int y); 
}

