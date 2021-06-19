package mp.bridgeSceneFigures;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTextField;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import tags301.Comp301Tags;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags(Comp301Tags.DELEGATING_BRIDGE_SCENE_VIEW)
public class ABridgeSceneView implements BridgeSceneView {

	public ABridgeSceneView() {
		BridgeScene myScene = AFactory.bridgeSceneFactoryMethod(); 
		BridgeScenePainter aBridgeScenePainter = AFactory.observableBridgeScenePainterFactoryMethod(); 
		MouseAndKeyListener aController = AFactory.bridgeSceneControllerFactoryMethod();  
		
		PaintListener arthurPainter = new AnAvatarPainter(myScene.getArthur());
		aBridgeScenePainter.addPaintListener(arthurPainter);
		PaintListener galahadPainter = new AnAvatarPainter(myScene.getGalahad());
		aBridgeScenePainter.addPaintListener(galahadPainter);
		PaintListener guardPainter = new AnAvatarPainter(myScene.getGuard()); 
		aBridgeScenePainter.addPaintListener(guardPainter);
		PaintListener lancelotPainter = new AnAvatarPainter(myScene.getLancelot()); 
		aBridgeScenePainter.addPaintListener(lancelotPainter);
		PaintListener robinPainter = new AnAvatarPainter(myScene.getRobin());
		aBridgeScenePainter.addPaintListener(robinPainter);
		
		PaintListener knightAreaPainter = new AnAreaPainter(((ABetterBridgeScene)myScene).getKnightArea());
		aBridgeScenePainter.addPaintListener(knightAreaPainter);
		PaintListener guardAreaPainter = new AnAreaPainter(((ABetterBridgeScene)myScene).getGuardArea());
		aBridgeScenePainter.addPaintListener(guardAreaPainter);
		
		PaintListener aGorgePainter = new AGorgePainter(((ABetterBridgeScene)myScene).getGorge()); 
		aBridgeScenePainter.addPaintListener(aGorgePainter);
		
		((ABetterBridgeScene)myScene).approach("Lancelot");
		((ABetterBridgeScene)myScene).say("Hello");
		((ABetterBridgeScene)myScene).failed(); 
		
		
		JFrame aFrame = new JFrame("MyScene");
		aFrame.setSize(100, 10); 
		aFrame.add((Component) aBridgeScenePainter);
		aFrame.pack();
		aFrame.setVisible(true); 
		
		
	}	
}
