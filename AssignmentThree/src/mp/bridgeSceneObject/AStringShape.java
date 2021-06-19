package mp.bridgeSceneObject;
import java.beans.PropertyChangeEvent;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
public class AStringShape extends ALocatable implements StringShape {
	 
	static final String STRING = "";  
	protected String stringText = STRING; 
	
	@Override
	public String getText() { return this.stringText;}
	@Override
	public void setText(String val) { 
		String previousText = getText(); 
		this.stringText = val;
		aListener.notifyAllListeners(new PropertyChangeEvent(this, "Text", previousText, getText()));
	}
}

