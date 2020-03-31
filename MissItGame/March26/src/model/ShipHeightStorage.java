package model;

public enum ShipHeightStorage {
	
	SHIP1(34);
	
	private double Height;
	
	ShipHeightStorage(double height){
		Height = height;
		
	}
	
	public double getHeight(){
		return Height;
	}
	

}
