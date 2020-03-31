package screen;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Obstacles extends ImageView{
	
	
	private double movementMultiplier = .1;
	private double ObstacleWidth;
	private double ObstacleHeight;
	private Random random;
	private GameScreen GamePane;
	private double GameWidth;
	private double GameHeight;
	private double ObstacleY;
	private double ObstacleX;
	
	
	
	Obstacles (String URL, double width, double height){
		super(URL);
		ObstacleWidth = width;
		ObstacleHeight = height;		
		super.prefWidth(ObstacleWidth);
		super.prefHeight(ObstacleHeight);
		random = new Random();
		
	}
	
	public void placeObstacle(double Width, double Height) {
		
		GameWidth = Width;
		GameHeight = Height;
		
		int randomInt = random.nextInt((int)GameWidth);
		
		ObstacleY = 0;
		ObstacleX = randomInt;
		
		setLayoutY(ObstacleY);
		setLayoutX(ObstacleX);
		
		}
	
	public double getObstacleX() {
		return ObstacleX;
	}
	public double getObstacleY() {
		return ObstacleY;
	}
	public double getWidth() {
		return ObstacleWidth;
	}
	public double getHeight() {
		return ObstacleHeight;
	}
	
	
	
	
	
	public void moveObstacle() {
		
		ObstacleY = ObstacleY + movementMultiplier;
		setLayoutY(ObstacleY);
		movementMultiplier = movementMultiplier + .005;
		
		
		
	}
	
	

	
}
