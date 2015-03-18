package moba.gameobj;

public abstract class Shop implements GameObject {

	// variables
	private int positionX;
	private int positionY;
	
	// constructor
	public Shop (int x, int y) {
		this.positionX = x;
		this.positionY = y;
	}
	
	@Override
	public String toString() {
		return "Shop";
	}
}
