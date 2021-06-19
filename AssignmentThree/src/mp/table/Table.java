package mp.table;

import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags(Comp301Tags.TABLE)
@StructurePattern(StructurePatternNames.MAP_PATTERN)
public interface Table<T> {

	T get(String key);
	void put(String key, T val);
}

