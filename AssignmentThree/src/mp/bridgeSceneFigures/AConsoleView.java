package mp.bridgeSceneFigures;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.CONSOLE_SCENE_VIEW)
public class AConsoleView implements ConsoleView {
	
	public AConsoleView() {
		BridgeScene aScene = AFactory.bridgeSceneFactoryMethod(); 
		((ABetterBridgeScene) aScene).registerListener(this);
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt); 
		
	}
}
