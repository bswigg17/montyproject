package mp.bridgeSceneObject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.bridgeSceneFigures.AConsoleView;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.BOUNDED_SHAPE)
public class ABoundedShape extends ADeminsion implements BoundedShape {
	
	public ABoundedShape() {}
	public ABoundedShape(int aWidth, int aHeight) {this.width=aWidth; this.height=aHeight;}
	public ABoundedShape(int aWidth, int aHeight, int xCord, int yCord) {
		this.width=aWidth; 
		this.height=aHeight;
		this.x = xCord;
		this.y = yCord;
	}
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		aListener.add(listener);
	}
	@Override
	public void setWidth(int val) {
		int previousWidth = getWidth(); 
		this.width = val; 
		aListener.notifyAllListeners(new PropertyChangeEvent(this, "Width", previousWidth, getWidth()));
		
	}
	@Override
	public void setHeight(int val) {
	int previousHeight = getHeight(); 
	this.width = val; 
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "Height", previousHeight, getHeight()));
		
	}
	
}
