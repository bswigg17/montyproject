package mp.bridgeSceneFigures;
import mp.bridgeSceneObject.ALine;
import tags301.Comp301Tags; 
import mp.bridgeSceneObject.Line;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags; 


@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"LeftLine",
	"RightLine",
})

@Tags(Comp301Tags.ANGLE)
public class AngleShape implements Angle {
	
	static final double RADIUS = 50.0, LEFT_ANGLE = 3*((Math.PI)/4), RIGHT_ANGLE= Math.PI/4; 
		 
	protected Line leftLine, rightLine;
	
	public AngleShape() {
		leftLine =  new ALine(RADIUS, LEFT_ANGLE);
		rightLine = new ALine(RADIUS, RIGHT_ANGLE);
	}
	
	public AngleShape(double radius, double leftAngle, double rightAngle) {
		leftLine =  new ALine(radius, leftAngle);
		rightLine = new ALine(radius, rightAngle);
	}
	
	@Override
	public void scale(double val) {
		this.leftLine.setRadius(val * leftLine.getRadius());
		this.rightLine.setRadius(val * rightLine.getRadius());
	}
	
	@Override
	public void move(int xVal, int yVal) { 
		setPos(this.leftLine.getX() + xVal, this.rightLine.getY() + yVal); 
		} 
	@Override
	public Line getLeftLine() { return this.leftLine; }
	@Override
	public Line getRightLine() { return this.rightLine; }
	@Override
	public void setPos(int xVal, int yVal) { 
		this.leftLine.move(xVal, yVal); 
		this.rightLine.move(xVal, yVal);
	}
	@Override
	public void registerListener(PropertyChangeListener aListener) {
		this.getLeftLine().addPropertyChangeListener(aListener);
		this.getRightLine().addPropertyChangeListener(aListener);
	}
}
