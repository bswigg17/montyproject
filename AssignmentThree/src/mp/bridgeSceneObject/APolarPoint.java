package mp.bridgeSceneObject;
import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;


@StructurePattern(StructurePatternNames.POINT_PATTERN)
@PropertyNames({
	"X",
	"Y", 
})
@EditablePropertyNames({
	"X",
	"Y", 
})
public class APolarPoint extends ALocatable implements PolarPoint {
	
	static final double RADIUS=100, ANGLE=100;
 
	
	protected double radius=RADIUS, angle=ANGLE;  
	
	public APolarPoint(double aRadius, double anAngle) {
		this.radius = aRadius;
		this.angle = anAngle; 
	}
	
	public APolarPoint() {
		
	}
	
	
	@Override
	public int getX() {return (int) (radius*Math.cos(angle));}
	@Override
	public int getY() {return (int) (radius*Math.sin(angle));}
	@Override
	public double getRadius() {return this.radius;}
	@Override
	public double getAngle() {return this.angle;}
	@Override
	public void changeAngle(double val) {
		double previousAngle = getAngle(); 
		this.angle = val;
		aListener.notifyAllListeners(new PropertyChangeEvent(this, "Angle", previousAngle, getAngle()));}
	@Override
	public void setRadius(double val) {
		double previousRadius = getRadius(); 
		this.radius = val;
		aListener.notifyAllListeners(new PropertyChangeEvent(this, "Radius", previousRadius, getRadius()));}
	
	
}
