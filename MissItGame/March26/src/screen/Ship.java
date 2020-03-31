package screen;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Ship extends ImageView{
	private double ShipWidth;
	private double ShipHeight;
	private String URL;
	private double ShipY;
	private double ShipX;
	private double GameWidth;
	private double GameHeight;
	private double Rotation;
	
	private double MoveAmount = .5;
	private double RotateAmount = 5;
	
	
	
	Ship(String URL,double width,double height){
		super(URL);
		this.URL = URL;
		ShipWidth = width;
		ShipHeight = height;
		super.prefHeight(height);
		super.prefWidth(width);
		Rotation = 0;
		
	}
	
	public double getShipHeight() {
		return ShipHeight;
	}
	public double getShipWidth() {
		return ShipWidth;
	}
	
	
	
	public double startShipX(Pane gamePane) {
		GameWidth = gamePane.getPrefWidth();
		double difference = GameWidth - ShipWidth;
		double xPos = difference /2;
		ShipX = xPos;
		return xPos;
		
	}
	
	public double startShipY(Pane gamePane) {
		int pixelsAboveBottom = 5;
		GameHeight = gamePane.getPrefHeight();
		double maxY = GameHeight - ShipHeight;
		double yPos = maxY - pixelsAboveBottom;
		ShipY = yPos;	
		return yPos;
		
	}
	
	public void moveLeft() {
		if (ShipX > 0 ) {
		ShipX = ShipX - MoveAmount;
		}
		if (getRotate() > -30) {
			Rotation = Rotation - RotateAmount;
		}
	}
	
	public void moveRight() {
		if (ShipX + ShipWidth < GameWidth) {
		ShipX = ShipX + MoveAmount;
		
		}
		if (getRotate() < 30) {
			Rotation = Rotation + RotateAmount;
			
		}
	}
	
	public void noInput() {
		if (getRotate() < 0) {
			Rotation = Rotation + RotateAmount;
			

		}
		
		else if (getRotate( ) > 0) {
			Rotation = Rotation - RotateAmount;
		}
		
	}
	
	public void moveUp() {
		if (ShipY > 0) {
			ShipY = ShipY - MoveAmount;
		}
		
	}
	
	
	public void moveDown() {
		if (ShipY + ShipHeight + 1 < GameHeight) {
			ShipY = ShipY + MoveAmount;
		}
		
	}
	
	public double getShipX() {
		return ShipX;
		
	}
	
	public double getShipY() {
		return ShipY;
		
	}
	
	public void updatePosition() {
		setLayoutX(ShipX);
		setLayoutY(ShipY);
		setRotate(Rotation);
	}
	
	
	
	
	
	

}
