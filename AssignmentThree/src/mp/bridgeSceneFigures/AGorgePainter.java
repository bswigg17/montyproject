package mp.bridgeSceneFigures;

import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import mp.bridgeSceneObject.Line;
import mp.bridgeSceneObject.Square;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.PAINT_LISTENER)
public class AGorgePainter implements PaintListener {

	BridgeScenePainter aPainter = AFactory.observableBridgeScenePainterFactoryMethod();
	Gorge aGorge; 
	
	public AGorgePainter(Gorge aGorge) {
		this.aGorge = aGorge; 
		listenTo(); 
	}
	
	void listenTo() {
		this.aGorge.registerListener(this);
	}
	
	@Override
	public void paint(Graphics2D g) {
		paint(g, this.aGorge.getASquare()); 
		paint(g, this.aGorge.getLeftLine());
		paint(g, this.aGorge.getRightLine()); 
	}
	
	void paint(Graphics2D g, Square aSquare) {
		g.drawRect(aSquare.getX(), aSquare.getY(), aSquare.getWidth(), aSquare.getHeight());
	}
	
	void paint(Graphics2D g, Line aLine) {
		g.drawLine(aLine.getX(), aLine.getY(), aLine.getX() + aLine.getWidth(), aLine.getY() + aLine.getHeight());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		((ABridgeScenePainter) aPainter).repaint();
	}
}
