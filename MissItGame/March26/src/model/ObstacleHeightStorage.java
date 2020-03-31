package model;

public enum ObstacleHeightStorage {

	OBSTACLE1(29);
	
	
private double Height;
	
	ObstacleHeightStorage(double height){
		Height = height;
	}
	
	public double getHeight() {
		return Height;
	}
}
