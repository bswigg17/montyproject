package mp.bridgeSceneFigures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.beans.PropertyChangeEvent;

import mp.bridgeSceneObject.Head;
import mp.bridgeSceneObject.Line;
import mp.bridgeSceneObject.StringShape;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.PAINT_LISTENER)
public class AnAvatarPainter implements PaintListener {

	BridgeScenePainter aPainter= AFactory.observableBridgeScenePainterFactoryMethod(); 
	Avatar anAvatar; 
	
	public AnAvatarPainter(Avatar anAvatar) {
		this.anAvatar = anAvatar; 
		listenTo(); 
	}
	
	void listenTo() {
		anAvatar.registerListener(this);
	}
	
	@Override
	public void paint(Graphics2D g) { 
		paint(g, this.anAvatar.getSpine()); 
		paint(g, this.anAvatar.getLegs());
		paint(g, this.anAvatar.getArms()); 
		paint(g, this.anAvatar.getHead()); 
		paint(g, this.anAvatar.getStringShape()); 
		System.out.println("Painted");
		
	}
	public void paint(Graphics2D g, Angle anAngle) {
		paint(g, anAngle.getLeftLine()); 
		paint(g, anAngle.getRightLine()); 
	}
	
	public void paint(Graphics2D g, Line aLine) {
		g.drawLine(aLine.getX(), aLine.getY(), aLine.getX() + aLine.getWidth(), aLine.getY() + aLine.getHeight()); 
	}
	
	public void paint(Graphics2D g, Head aHead) {
		Image img = Toolkit.getDefaultToolkit().getImage(aHead.getImageFileName());
		g.drawImage(img, aHead.getX(), aHead.getY(), aHead.getWidth(), aHead.getHeight(), (ABridgeScenePainter)aPainter); 
		
	}
	
	void paint(Graphics2D g, StringShape aStringShape) {
		g.drawString(aStringShape.getText(), aStringShape.getX(), aStringShape.getY());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		((ABridgeScenePainter) aPainter).repaint();
		System.out.println("Repainted"); 
	}

}
