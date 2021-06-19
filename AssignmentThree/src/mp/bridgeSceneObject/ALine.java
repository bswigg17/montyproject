package mp.bridgeSceneObject;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.bridgeSceneFigures.Avatar;
import mp.bridgeSceneFigures.Body;
import tags301.Comp301Tags;
import util.annotations.Tags;
import util.annotations.Visible;
import util.misc.ThreadSupport;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;


@StructurePattern(StructurePatternNames.LINE_PATTERN)

@Tags(Comp301Tags.ROTATING_LINE)
public class ALine extends ADeminsion implements Line {

PolarPoint polarPoint; 

public ALine(double radius, double angle) {
	polarPoint = new APolarPoint(radius, angle); 
}

public ALine() {
	polarPoint = new APolarPoint(); 
}

@Override
public int getWidth() {return polarPoint.getX();}
@Override
public int getHeight() {return polarPoint.getY();}
@Override
public void rotate(int val) {
	int previousHeight=getHeight(), previousWidth=getWidth(); 
	polarPoint.changeAngle((val* (Math.PI/16)) + polarPoint.getAngle());
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "Height", previousHeight, getHeight()));
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "Height", previousWidth, getWidth()));}
@Override
public void setRadius(double val) {
	double previousWidth = getWidth();
	double previousHeight = getHeight();
	polarPoint.setRadius(val);
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "Width", previousWidth, getWidth()));
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "Height", previousHeight, getHeight()));
}
@Override
public void setAngle(double val) {
	double previousWidth = getWidth();
	double previousHeight = getHeight(); 
	polarPoint.changeAngle(val);
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "Width", previousWidth, getWidth()));
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "Height", previousHeight, getHeight()));
}
@Override
public double getRadius() { return polarPoint.getRadius(); }
@Override 
public double getAngle() { return polarPoint.getAngle(); }
@Override
public void move(int x, int y) { 
	int previousX= getX(), previousY=getY(); 
	this.x= x;  
	this.y=y; 
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "X", previousX, getX())); 
	aListener.notifyAllListeners(new PropertyChangeEvent(this, "Y", previousY, getY())); 
}

@Override
public void registerListener(PropertyChangeListener aListener) {
	this.addPropertyChangeListener(aListener);
	super.aListener.notifyAll();
	
}

@Override
public void changeAngle(double val) {
	polarPoint.changeAngle(val);
}

}
