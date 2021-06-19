package mp.bridgeSceneFigures;

import java.beans.PropertyChangeListener;

public interface Move {

	void registerListener(PropertyChangeListener aListener); 
	void move(int x, int y); 
	
}
