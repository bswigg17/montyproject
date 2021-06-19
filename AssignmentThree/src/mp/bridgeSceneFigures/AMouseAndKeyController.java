package mp.bridgeSceneFigures;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.BRIDGE_SCENE_CONTROLLER)
public class AMouseAndKeyController implements MouseAndKeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BridgeScenePainter aPainter;  
	BridgeScene aBridgeScene = AFactory.bridgeSceneFactoryMethod();
	int mouseX, mouseY;  
		
	public AMouseAndKeyController(BridgeScenePainter aPainter) {
		this.aPainter = aPainter; 
		((ABridgeScenePainter) aPainter).addKeyListener(this);
		((ABridgeScenePainter) aPainter).addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("MouseEvent"); 
		mouseX = (int) e.getPoint().getX(); 
		mouseY = (int) e.getPoint().getY(); 
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseX = (int) e.getPoint().getX(); 
		mouseY = (int) e.getPoint().getY(); 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseX = (int) e.getPoint().getX(); 
		mouseY = (int) e.getPoint().getY(); 
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char typedChar = e.getKeyChar();
    	switch (typedChar) {
    	case 'a' :
    		aBridgeScene.getArthur().setPosition(mouseX, mouseY); 
    		break;
    	case 'g':
    		aBridgeScene.getGalahad().setPosition(mouseX, mouseY);
    		break;
    	case 'l' :
    		aBridgeScene.getLancelot().setPosition(mouseX, mouseY);
    		break;
    	case 'r':
    		aBridgeScene.getRobin().setPosition(mouseX, mouseY);
    		break;	
    	case 'o':
    		aBridgeScene.reset(); 	
  
    	}    
	}	
		

	@Override
	public void keyPressed(KeyEvent e) {
		char typedChar = e.getKeyChar();
    	switch (typedChar) {
    	case 'a' :
    		aBridgeScene.getArthur().setPosition(mouseX, mouseY);
    		break;
    	case 'g':
    		aBridgeScene.getGalahad().setPosition(mouseX, mouseY);
    		break;
    	case 'l' :
    		aBridgeScene.getLancelot().setPosition(mouseX, mouseY);
    		break;
    	case 'r':
    		aBridgeScene.getRobin().setPosition(mouseX, mouseY);
    		break;	
    	case 'o':
    		aBridgeScene.reset(); 
  
    	}  
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
