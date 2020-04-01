package screen;

import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class ScoreScreen extends SubScene{
	
	
	private double xCoordinate;
	private double yCoordinate;
	private static Pane ScorePane;
	private ScoreLabel ScoreLabel;
	private String ScoreString;
	private int ScoreInt;

	public ScoreScreen(double width, double height) {
		super(ScorePane = new Pane(), width, height);
		
		this.setOpacity(.5);
		
		createScoreDisplay();
		
		
	}
	
	private void createScoreDisplay() {
		ScoreLabel = new ScoreLabel();
		ScoreLabel.setText(ScoreString);
		ScoreLabel.setFont(new Font(26));
		ScorePane.getChildren().add(ScoreLabel);
		
		
	}


	public int setScore(int score) {
		ScoreString = score + "";
		ScoreLabel.setText(ScoreString);
		ScoreInt = score;
		

		return ScoreInt;
	}
	
	public int getScore() {
		return ScoreInt;
	}
	
	
	
	
	
	
		
		
	}
	
	
	
	
	
	

