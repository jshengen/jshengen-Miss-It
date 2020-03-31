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
		prefHeight(height);
		prefWidth(width);
		Rotation = 0;
		
	}
	
	public double getShipHeight() {
		return ShipHeight;
	}
	public double getShipWidth() {
		return ShipWidth;
	}
	public void setMoveAmount(double amount) {
		MoveAmount = amount;
	}
	
	
	public double startShipX(double paneWidth) {
		GameWidth = paneWidth;
		double difference = GameWidth - ShipWidth;
		ShipX = difference /2;
	
		return ShipX;
		
	}
	
	public double startShipY(double paneHeight) {
		int pixelsAboveBottom = 5;
		GameHeight = paneHeight;
		double maxY = GameHeight - ShipHeight;
		ShipY = maxY - pixelsAboveBottom;
		
		return ShipX;
		
	}
	
	public void moveLeft() {
		if (ShipX >  MoveAmount ) {
		ShipX = ShipX - MoveAmount;
	
		}
		if (getRotate() > -30) {
			Rotation = Rotation - RotateAmount;
		}
	}
	
	public void moveRight() {
		if(ShipWidth >= MoveAmount) {
		

			if (ShipX + ShipWidth < GameWidth) {
				ShipX = ShipX + MoveAmount;
			
			}
		}
		if(MoveAmount > ShipWidth) {		
	
			if (ShipX + MoveAmount + ShipWidth < GameWidth) {
				ShipX = ShipX + MoveAmount;
					
			}
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
		if (ShipY - MoveAmount > 0) {
			ShipY = ShipY - MoveAmount;
		}
		
	}
	
	
	public void moveDown() {
		if (ShipHeight > MoveAmount ) {
			if (ShipY + ShipHeight + 1 < GameHeight) {
				ShipY = ShipY + MoveAmount;
			}
		}
		else if (ShipY + MoveAmount + 1 < GameHeight) {
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
