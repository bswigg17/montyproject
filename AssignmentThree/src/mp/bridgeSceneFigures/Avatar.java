package mp.bridgeSceneFigures;
import java.beans.PropertyChangeListener;

import mp.bridgeSceneObject.Head;
import mp.bridgeSceneObject.Line;
import mp.bridgeSceneObject.StringShape;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags(Comp301Tags.AVATAR)
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
public interface Avatar extends Move {

	static final int SPINE_LENGTH=70; 
	static final String STRING = "images/galahad.jpg"; 

	void constructBody();  
	public void scale(double val); 
	public Line getSpine(); 
	public Angle getArms();  
	public Angle getLegs(); 
	public Head getHead(); 
	public StringShape getStringShape();
	public void setChatBoxText(String val);
	void setPosition(int xVal, int yVal);
	
}
