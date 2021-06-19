package mp.bridgeSceneFigures;

import mp.table.ATable;
import mp.table.Table;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.FACTORY_CLASS)
public class AFactory {
	
	static BetterBridgeScene scene; 
	static ConsoleView view;
	static ABridgeScenePainter aPainter; 
	static MouseAndKeyListener aController; 
	static Table<Avatar> aTable; 
	static BridgeSceneView aView; 
	
	public static BetterBridgeScene bridgeSceneFactoryMethod() {
		if (scene == null) {
			scene = new ABetterBridgeScene();
		}
		return scene; 
	}
	
	public static ConsoleView consoleSceneViewFactoryMethod() {
		if (view == null) {
			view = new AConsoleView(); 
		}
		return view; 
	}

	public static Angle legsFactoryMethod(double length, double leftAngle, double rightAngle) {
		return new AngleShape(length, leftAngle, rightAngle); 
	}
	
	public static BridgeScenePainter observableBridgeScenePainterFactoryMethod() {
		if (aPainter == null) {
			aPainter = new ABridgeScenePainter(); 
		}
		return aPainter; 
	}
	
	public static BridgeSceneView delegatingBridgeSceneViewFactoryMethod() {
		if (aView == null) {
			aView = new ABridgeSceneView(); 
		}
		return aView; 
	}
	
	public static MouseAndKeyListener bridgeSceneControllerFactoryMethod() {
		if (aController == null) {
			aController = new AMouseAndKeyController(AFactory.observableBridgeScenePainterFactoryMethod()); 
		}
		return aController; 
	}
	
	public static Table<Avatar> avatarTableFactoryMethod() {
		if (aTable == null) {
			aTable = new ATable<Avatar>(); 
		}
		return aTable; 
	}
}