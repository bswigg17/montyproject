package mp.bridgeSceneFigures;
import java.beans.PropertyChangeListener;

import mp.bridgeSceneObject.AHead;
import mp.bridgeSceneObject.APropertyListenerSupport;
import mp.bridgeSceneObject.PropertyListenerSupport;
import mp.table.ATable;
import mp.table.Table;
import tags301.Comp301Tags;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags(Comp301Tags.BRIDGE_SCENE) 
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"Arthur",
	"Galahad",
	"Guard",
	"Lancelot",
	"Robin",
})
public class ABridgeScene implements BridgeScene { 
	
	PropertyListenerSupport aListener = new APropertyListenerSupport(); 
	
	static final int X_POS_ONE=50, X_POS_TWO=50, X_POS_FOUR=150, X_POS_FIVE=150,
			Y_POS_ONE=500, Y_POS_TWO=700;  
	
	protected Avatar arthur, galahad, guard, lancelot, robin; 
	
	public ABridgeScene() {
		arthur = new Body(new AHead("images/arthur.jpg"), X_POS_ONE, Y_POS_ONE);
		AFactory.avatarTableFactoryMethod().put("Arthur", arthur); 
		galahad = new Body(new AHead("images/galahad.jpg"), X_POS_TWO, Y_POS_TWO);
		AFactory.avatarTableFactoryMethod().put("Galahad", galahad);
		guard = new Body(new AHead("images/guard.jpg"));
		AFactory.avatarTableFactoryMethod().put("Guard", guard);
		lancelot = new Body(new AHead("images/lancelot.jpg"), X_POS_FOUR, Y_POS_ONE);
		AFactory.avatarTableFactoryMethod().put("Lancelot", lancelot);
		robin = new Body(new AHead("images/robin.jpg"), X_POS_FIVE, Y_POS_TWO);
		AFactory.avatarTableFactoryMethod().put("Robin", robin);
	}
	
	public void reset() {
		getArthur().setPosition(X_POS_ONE, Y_POS_ONE);
		getGalahad().setPosition(X_POS_TWO, Y_POS_TWO);
		getLancelot().setPosition(X_POS_FOUR, Y_POS_ONE);
		getRobin().setPosition(X_POS_FIVE, Y_POS_TWO);
	}
	
	
	@Override
	public Avatar getArthur() { return this.arthur; }
	@Override
	public Avatar getGalahad() { return this.galahad; }
	@Override
	public Avatar getGuard() { return this.guard; }
	@Override
	public Avatar getLancelot() { return this.lancelot; }
	@Override
	public Avatar getRobin() { return this.robin; }
}
