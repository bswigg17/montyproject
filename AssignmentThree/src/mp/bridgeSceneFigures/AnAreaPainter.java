package mp.bridgeSceneFigures;

import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import mp.bridgeSceneObject.Line;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.PAINT_LISTENER)
public class AnAreaPainter implements PaintListener {

	BridgeScenePainter aPainter= AFactory.observableBridgeScenePainterFactoryMethod(); 
	Area anArea; 
	
	public AnAreaPainter(Area anArea) {
		this.anArea = anArea; 
		listenTo(); 
	}
	
	void listenTo() {
		anArea.registerListener(this);
	}
	
	@Override
	public void paint(Graphics2D g) { 
		g.drawOval(this.anArea.getX(), this.anArea.getY(), this.anArea.getWidth(), this.anArea.getHeight()); 
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		((ABridgeScenePainter) aPainter).repaint();
		System.out.println("Repainted"); 
	}
}
