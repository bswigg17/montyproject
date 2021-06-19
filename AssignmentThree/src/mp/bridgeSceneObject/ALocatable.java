package mp.bridgeSceneObject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.bridgeSceneFigures.AConsoleView;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;


@Tags(Comp301Tags.LOCATABLE)
@PropertyNames({
	"X",
	"Y", 
})
@EditablePropertyNames({
	"X",
	"Y", 
})
public class ALocatable implements Locatable {

	static final int X=100, Y=100;
	protected int x=X, y=Y; 
	PropertyListenerSupport aListener = new APropertyListenerSupport();
	
	public ALocatable() {}
	
	public ALocatable(int xCord, int yCord) {
		this.x = xCord;
		this.y = yCord; 
	}
	@Override
	public int getX() { return this.x; }
	@Override
	public int getY() { return this.y; }
	@Override 
	public void setX(int val) { 
		int previousX = getX(); 
		this.x=val; 
		aListener.notifyAllListeners(new PropertyChangeEvent(this, "X", previousX, getX())); }
	@Override
	public void setY(int val) { 
		int previousY = getY(); 
		this.y=val; 
		aListener.notifyAllListeners(new PropertyChangeEvent(this, "Y", previousY, getY())); 
		
	}
	

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		aListener.add(listener);
	}
	
	
}
