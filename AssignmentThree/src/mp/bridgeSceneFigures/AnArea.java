package mp.bridgeSceneFigures;


import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.bridgeSceneObject.ACircle;

public class AnArea extends ACircle implements Area {
	
	static final int SIZE=125; 
	
	public AnArea(int x, int y) {
		super(SIZE, SIZE, x, y); 
	}
	@Override
	public void move(int x, int y) {
		this.setX(x+getX()); 
		this.setY(y+getY()); 
	}
	
	@Override
	public void registerListener(PropertyChangeListener aListener) {
		super.addPropertyChangeListener(aListener);
}
}
