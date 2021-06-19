package mp.bridgeSceneFigures;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.bridgeSceneObject.ALine;
import mp.bridgeSceneObject.ASquare;
import mp.bridgeSceneObject.Line;
import mp.bridgeSceneObject.Square;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"LeftLine",
	"RightLine",
	"ASquare", 
})
public class AGorge implements Gorge {
	
	static final int LINE_LENGTH=1000; 
	static final double ANGLE=Math.PI/2; 
	static final int GORGE_X_POS=1000, GORGE_Y_POS=600; 
	
	Line leftLine, rightLine; 
	Square aSquare; 
	
	public AGorge() {
		leftLine = new ALine(LINE_LENGTH, ANGLE); 
		rightLine = new ALine(LINE_LENGTH, ANGLE); 
		aSquare = new ASquare(); 
		setGorge(GORGE_X_POS, GORGE_Y_POS); 
	}
	
	private void setGorge(int x, int y) {
		aSquare.setX(x);
		aSquare.setY(y);
		leftLine.setX(x);
		leftLine.setY(0);
		rightLine.setX(x + aSquare.getWidth());
		rightLine.setY(0);
	}
	@Override
	public void move(int x, int y) {
		setGorge( x + getLeftLine().getX(), y + getASquare().getY()); 
	}
	@Override
	public void registerListener(PropertyChangeListener aListener) {
		this.getLeftLine().addPropertyChangeListener(aListener);
		this.getRightLine().addPropertyChangeListener(aListener);
		this.getASquare().addPropertyChangeListener(aListener);
	}
	@Override
	public Line getLeftLine() { return this.leftLine; }
	@Override
	public Line getRightLine() { return this.rightLine; }
	@Override
	public Square getASquare() { return this.aSquare; }
}

