package mp.bridgeSceneFigures;

import java.beans.PropertyChangeListener;

import tags301.Comp301Tags;
import util.annotations.PropertyNames;
import util.annotations.Tags;
@Tags(Comp301Tags.BRIDGE_SCENE)
@PropertyNames({
	"Gorge",
	"KnightArea",
	"GuardArea", 
	"Occupied", 
	"KnightTurn",
	"InteractingKnight",
	"Arthur",
	"Galahad",
	"Guard",
	"Lancelot",
	"Robin",
})

public interface BetterBridgeScene extends BridgeScene, Move {
	Gorge getGorge(); 
	Area getKnightArea();
	Area getGuardArea(); 
	void approach(Avatar aKnight);
	Boolean getOccupied(); 
	void say(String text);
	Boolean getKnightTurn();
	void passed(); 
	void failed();
	void scroll(int x, int y);
	Avatar getInteractingKnight();
	void registerListener(PropertyChangeListener aListener);
	void approach(String aKnightName);
}
