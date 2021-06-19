package mp.bridgeSceneFigures;
import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.bridgeSceneObject.AHead;
import mp.bridgeSceneObject.ALine;
import mp.bridgeSceneObject.AStringShape;
import mp.bridgeSceneObject.Head;
import mp.bridgeSceneObject.Line;
import mp.bridgeSceneObject.StringShape;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"Spine",
	"Arms",
	"Legs",
	"Head",
	"StringShape",
	"ChatBoxText",
})
@EditablePropertyNames({
	"ChatBoxText", 
})
@Tags(Comp301Tags.AVATAR)
public class Body implements Avatar {
	
	static final double RADIUS = 50.0, LEFT_ANGLE = 3*((Math.PI)/4), RIGHT_ANGLE= Math.PI/4; 
	static final int INIT_X=200, INIT_Y=200; 
	static final double SPINE_POS = -(Math.PI/2), INIT_SPINE_LEN=70, NECK_LEN=10; 
	static final String INIT_STRING = "images/galahad.jpg"; 
	
	protected int x=INIT_X, y=INIT_Y; 
	protected double spineLength = INIT_SPINE_LEN; 
	
	protected Head head; 
	protected Line spine; 
	protected Angle legs; 
	protected Angle arms; 
	protected StringShape chatBox; 
	
	public Body(Head aHead) {
		this.legs = AFactory.legsFactoryMethod(RADIUS, LEFT_ANGLE, RIGHT_ANGLE); 
		this.arms = new AngleShape(RADIUS, LEFT_ANGLE, RIGHT_ANGLE); 
		this.head = aHead;  
		this.spine = new ALine(INIT_SPINE_LEN, SPINE_POS);
		this.chatBox = new AStringShape(); 
		
		constructBody(); 
	}
	
	public Body(Head aHead, int xVal, int yVal) {
		
		this.x = xVal; 
		this.y= yVal; 
		
		this.legs = AFactory.legsFactoryMethod(RADIUS, LEFT_ANGLE, RIGHT_ANGLE); 
		this.arms = AFactory.legsFactoryMethod(RADIUS, LEFT_ANGLE, RIGHT_ANGLE); 
		this.head = aHead;  
		this.spine = new ALine(INIT_SPINE_LEN, SPINE_POS); 
		this.chatBox = new AStringShape(); 
		
		constructBody(); 
	}
	
	@Override 
	public void constructBody() { 
		
		this.head.setX(toHeadX());
		this.head.setY(toHeadY());
		
		this.spine.setX(x);
		this.spine.setY(y);
		this.spine.setRadius(this.spineLength);
	
		this.arms.setPos(x, toArmsY());
		
		this.legs.setPos(x, y);
		
		this.chatBox.setX(toChatBoxX());
		this.chatBox.setY(toChatBoxY());
	}
	
	private int toHeadX() { return this.x - (this.head.getWidth() / 2); }
	private int toHeadY() { return (int) (this.y - spineLength - head.getHeight()); } 
	private int toArmsY() { return (int) (this.y - spineLength + NECK_LEN); }
	private int toChatBoxX() { return this.x + (head.getWidth()/2); }
	private int toChatBoxY() { return (int) (this.y - spineLength - head.getHeight()); } 
	
	@Override 
	public void move(int xVal, int yVal) {
		this.x = this.x + xVal; 
		this.y = this.y + yVal; 
		constructBody(); 
	}
	
	@Override
	public void scale(double val) {
		((AngleShape) this.arms).scale(val);
		((AngleShape) this.legs).scale(val);
		this.spineLength *= val;  
		this.head.setWidth((int) (val * this.head.getWidth()));
		this.head.setHeight(((int) (val * this.head.getHeight())));
		constructBody(); 
	}
	@Override
	public void registerListener(PropertyChangeListener aListener) {
		this.getArms().registerListener(aListener);
		this.getLegs().registerListener(aListener);
		this.getHead().addPropertyChangeListener(aListener);
		this.getSpine().addPropertyChangeListener(aListener);
		this.getStringShape().addPropertyChangeListener(aListener);
	}
	
	
	@Override
	public Head getHead() { return this.head; }
	@Override
	public StringShape getStringShape() { return this.chatBox; }
	@Override
	public Line getSpine() { return this.spine; }
	@Override
	public Angle getArms() { return this.arms; } 
	@Override
	public Angle getLegs() { return this.legs;}
	@Override
	public void setChatBoxText(String val) { this.chatBox.setText(val); }
	@Override
	public void setPosition(int xVal, int yVal) { this.x=xVal; this.y=yVal; constructBody();}
}
