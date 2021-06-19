package mp.bridgeSceneFigures;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.OBSERVABLE_BRIDGE_SCENE_PAINTER)
public class ABridgeScenePainter extends Component implements BridgeScenePainter {
	
	public ABridgeScenePainter() {
		setFocusable(true); 
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 640058331697164342L;
	private ArrayList<PaintListener> paintListeners = new ArrayList<PaintListener>(); 

	public void addPaintListener(PaintListener aListener) {
		paintListeners.add(aListener); 
		System.out.println("Added One");
		repaint(); 
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g); 
		Graphics2D g2 = (Graphics2D) g;
		for(int i=0; i<paintListeners.size(); i++) {
			paintListeners.get(i).paint(g2);
		}

	}
	
	public List<PaintListener> getPaintListeners() { return this.paintListeners; }
}
