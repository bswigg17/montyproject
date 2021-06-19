package mp.bridgeSceneFigures;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.BRIDGE_SCENE_CONTROLLER)
public interface MouseAndKeyListener extends MouseListener, KeyListener {

	void keyTyped(KeyEvent e);
}
