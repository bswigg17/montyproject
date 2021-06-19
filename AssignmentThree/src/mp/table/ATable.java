package mp.table;

import java.util.ArrayList;
import java.util.List;

import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;


@StructurePattern(StructurePatternNames.MAP_PATTERN)
@Tags(Comp301Tags.TABLE)
public class ATable<T> implements Table {
	
	List<T> tableOfObjects;
	List<String> tableOfKeys;
	
	public ATable() {
		tableOfObjects = new ArrayList<T>(); 
		tableOfKeys = new ArrayList<String>(); 
	}

	@Override
	public T get(String key) {
		return tableOfObjects.get(tableOfKeys.indexOf(key)); 
	}

	@Override
	public void put(String key, Object val) {
		
		if (key == null || val == null) {
			
		}
		
		else if (tableOfKeys.contains(key)) {
			newPairing(key, (T) val); 
		}
		else {
			newKey(key, (T) val); 
		}
		
	}
	
	void newPairing(String key, T val) {
		tableOfObjects.set(tableOfKeys.indexOf(key), val); 
	}
	
	void newKey(String key, T val) {
		tableOfObjects.add(val);
		tableOfKeys.add(key);
	}

	

}

