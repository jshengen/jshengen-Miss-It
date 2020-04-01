package model;

public enum ObstacleWidthStorage {

	OBSTACLE1(30);
	
	private double Width;
	
	ObstacleWidthStorage(double width){
		Width = width;
	}
	
	public double getWidth() {
		return Width;
	}
	
}
