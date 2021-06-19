package mp.bridgeSceneFigures;



import mp.bridgeSceneObject.Line;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.ANGLE)
public interface Angle extends TwoLines {

	static final double RADIUS = 50.0, LEFT_ANGLE = 3*((Math.PI)/4), RIGHT_ANGLE= Math.PI/4;
	public void setPos(int x, int y);
	void scale(double val);
	
}
