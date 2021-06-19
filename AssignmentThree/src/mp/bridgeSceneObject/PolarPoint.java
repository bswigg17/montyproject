package mp.bridgeSceneObject;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

public interface PolarPoint extends Locatable {

	@PropertyNames({
		"X",
		"Y", 
	})
	@EditablePropertyNames({
		"X",
		"Y", 
	})
static final double RADIUS=100, ANGLE=100;  
 
	public double getRadius(); 
	public double getAngle(); 
	public void changeAngle(double val); 
	public void setRadius(double val); 
	
}

