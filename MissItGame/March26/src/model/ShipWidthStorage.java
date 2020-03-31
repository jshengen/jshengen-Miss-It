package model;

public enum ShipWidthStorage {

	SHIP1(41);
	
	private double Width;
	
	ShipWidthStorage(double width){
		Width = width;
		
	}
	
	public double getWidth(){
		return Width;
	}
	
	
	
}
