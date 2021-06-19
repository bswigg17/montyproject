package mp.bridgeSceneFigures;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import tags301.Comp301Tags;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.annotations.Visible;
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
public class ABetterBridgeScene extends ABridgeScene implements BetterBridgeScene {
	
	static final int X_KNIGHT=600, Y_KNIGHT=600, X_GUARD=800, Y_GUARD=600;
	static final int X_FAILED=450, Y_FAILED=-200, X_PASSED=500; 
	static final int Y_MOVEMENT =4; 
	static final Boolean FALSE= false; 
	
	protected int failedX=X_FAILED, failedY=Y_FAILED; 
	protected Gorge aGorge; 
	protected Area aKnightArea, aGuardArea;
	protected Boolean occupied=FALSE, knightTurn=FALSE;
	protected Avatar activeKnight=null; 

	public ABetterBridgeScene() {
		aGorge = new AGorge(); 
		aKnightArea = new AnArea(X_KNIGHT, Y_KNIGHT); 
		aGuardArea = new AnArea(X_GUARD, Y_GUARD);
		readyGuard(); 
	}
	
	void readyGuard() { 
		this.getGuard().setPosition(xGuard(), yGuard());
	}
	@Override
	public void approach(Avatar aKnight) {
		if (!(getOccupied())) {
			this.activeKnight = aKnight;
			this.activeKnight.setPosition(xKnight(), yKnight()); 
			this.occupied = true; 
		}
	}
	
	@Override 
	public void approach(String aKnightName) {
		approach(AFactory.avatarTableFactoryMethod().get(aKnightName)); 
	}
	
	@Override
	public void say(String text) {
		if (getOccupied() && !(getKnightTurn())) {
			this.getInteractingKnight().setChatBoxText("");
			this.getGuard().setChatBoxText(text);
			knightTurn = true; 
		}
		else if (getOccupied() && (getKnightTurn())) {
			this.getGuard().setChatBoxText("");
			this.getInteractingKnight().setChatBoxText(text);
			knightTurn = false; 
		}
	};

	@Override 
	public void move(int x, int y) {
		scroll(x, y); 
	}
	
	
	private int xGuard() { return X_GUARD + (aGuardArea.getWidth() / 2); }
	private int yGuard() { return Y_GUARD + (aGuardArea.getHeight() / Y_MOVEMENT); }
	private int xKnight() { return X_KNIGHT + (aKnightArea.getWidth() / 2); }
	private int yKnight() { return Y_KNIGHT + (aKnightArea.getHeight() / Y_MOVEMENT); }
	
	private void turnReset() {
		this.activeKnight = null;
		this.occupied = false; 
		this.knightTurn = false; 
	}
	@Override
	public Gorge getGorge() { return this.aGorge; }
	@Override
	public Area getKnightArea() { return this.aKnightArea; }
	@Override
	public Area getGuardArea() { return this.aGuardArea; }
	@Override
	public Boolean getOccupied() {return this.occupied; }
	@Override
	public Boolean getKnightTurn() {return this.knightTurn;}
	@Override@Visible(false)
	public Avatar getInteractingKnight() { return activeKnight; }
	@Override
	public void passed() {
		if (getOccupied() && (!getKnightTurn())) {
			this.getInteractingKnight().move(X_PASSED, 0);
			turnReset();  
		}
	} 
	@Override
	public void failed() {
		if (getOccupied() && (!getKnightTurn())) {
			this.getInteractingKnight().setChatBoxText("");
			this.getInteractingKnight().move(failedX, failedY);
			this.failedX += 30; 
			turnReset(); 
		}
		else if (getOccupied() && (getKnightTurn())) {
			this.getGuard().setChatBoxText("");
			this.getGuard().move(-Y_FAILED, Y_FAILED);
		}
	}
	@Override
	public void scroll(int x, int y) {
		getArthur().move(-x, -y);
		getGalahad().move(-x, -y);
		getGuard().move(-x, -y);
		getLancelot().move(-x, -y);
		getRobin().move(-x, -y);
		getGorge().move(-x, -y);
		getKnightArea().move(-x, -y);
		getGuardArea().move(-x,-y); 
		
	}
	@Override
	public void registerListener(PropertyChangeListener aListener) {
		this.getArthur().registerListener(aListener);
		this.getGalahad().registerListener(aListener);
		this.getGuard().registerListener(aListener);
		this.getLancelot().registerListener(aListener);
		this.getRobin().registerListener(aListener);
		this.getKnightArea().registerListener(aListener);
		this.getGuardArea().registerListener(aListener);
		this.getGorge().registerListener(aListener);
	}
	
}
