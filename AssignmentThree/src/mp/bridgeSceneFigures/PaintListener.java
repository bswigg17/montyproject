package mp.bridgeSceneFigures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.PAINT_LISTENER)
//@Tags(Comp301Tags.PAINT_LISTENER)
public interface PaintListener extends PropertyChangeListener {

	void paint(Graphics2D g); 
}
