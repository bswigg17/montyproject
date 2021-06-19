package mp.bridgeSceneObject;

public class ADeminsion extends ALocatable implements Deminsions {
	
	static final int WIDTH = 100, HEIGHT = 100; 
	protected int width=WIDTH, height=HEIGHT; 
	
	@Override
	public int getWidth() {
		return width; 
	}

	@Override
	public int getHeight() {
		return height; 
	}

}
