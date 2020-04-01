package screen;

import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.PlayButton;

public class LostScreen  {

	
	private String backgroundURL = "screen/resources/AlvarGull.jpeg";
	private String FontPath = "srs/model/resources/CaviarDreams.ttf";
	
	private static final Pane LostPane = new Pane();
	
	private Stage LostStage;
	
	private Stage MenuStage;
	
	private double ButtonFontSize = 36;
	
	private Scene LostScene;
	
	private double FontSize = 52;

	private static final double SceneHeight = 750;

	private static final double SceneWidth = 568;
	
	private StartScreen starter;

	private ScoreLabel HighScoreLabel;
	
	private GameScreen gameScreen;
	
	private LostScreen loser;
	
	private ScoreLabel CurrentScoreLabel;
	
	private List<Integer> ScoreList;
	
	private int HighScore = 0;
	
	private int CurrentScore;
	
	
	

	
	public LostScreen(Stage MenuStage, int currentScore) {
		
		CurrentScore = currentScore;
		
	
		
		ScoreList = new ArrayList();
		
		ScoreList.add(CurrentScore);
		
		this.MenuStage = MenuStage;
		
		buildScoreLabels();
		
		LostScene = new Scene(LostPane, SceneWidth, SceneHeight);

		
		LostPane.setPrefSize(SceneWidth, SceneHeight);
		
		LostStage = new Stage();
		
		LostStage.setScene(LostScene);
		
		BackgroundImage image = new BackgroundImage(new Image(backgroundURL, SceneWidth, SceneHeight, false, false ),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,null);
		
		LostPane.setBackground(new Background(image));
		
		createRestartButton();
		
		computeHighestScore();
		
		
		
		//LostStage.show();
		
		}
	
	public double getSceneWidth() {
		return SceneWidth;
	}

	public void showLostStage() {
		LostStage.show();
	}
	
	public double getSceneHeight() {
		return SceneHeight;
	}
	
	public Stage getStage() {
		return LostStage;
	}
	
	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
	
	public void setLostScreen(LostScreen lostScreen) {
		loser = lostScreen;
	}
	
	
	private void createRestartButton() {
		Label restart = new Label("You Lost,\n" + "You Loser,\n" + "Try Again!" );
		//restart.autosize();
		//restart.resize(SceneWidth, SceneHeight);
		Background back = new Background(new BackgroundFill(Color.BLUEVIOLET,null,null));
		restart.setBackground(back);
		
		restart.setLayoutX(50);
		restart.setLayoutY(250);
		restart.setFont(new Font(FontPath, FontSize));
		LostPane.getChildren().add(restart);
		
		PlayButton button = new PlayButton("PLAY AGAIN");
		
		button.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				
				MenuStage.show();
				
				
				starter.setLostStage(LostStage);
				gameScreen.setLostStage(LostStage);
				
				starter.setLostScreen(loser);
				
				LostStage.hide();
				
				
			}
		
		});
		
		button.setLayoutX(50);
		button.setLayoutY(500);
		button.setFont(new Font(ButtonFontSize));
		
		LostPane.getChildren().add(button);
		
		
		
	}
	
	
	
	private void buildScoreLabels() {
		
		
		HighScoreLabel = new ScoreLabel();
		CurrentScoreLabel = new ScoreLabel();
		
		HighScoreLabel.setText("High Score: " + HighScore + "");
		CurrentScoreLabel.setText("Current Score " + CurrentScore + "");
		
		Background BackGround = new Background(new BackgroundFill(Color.CHOCOLATE,null,null));
		HighScoreLabel.setBackground(BackGround);
		CurrentScoreLabel.setBackground(BackGround);
		
		HighScoreLabel.setLayoutY(50);
		HighScoreLabel.setLayoutX(0);
		
		CurrentScoreLabel.setLayoutX(0);
		CurrentScoreLabel.setLayoutY(120);
		
		HighScoreLabel.setFont(new Font(46));
		CurrentScoreLabel.setFont(new Font(46));
		
		LostPane.getChildren().add(HighScoreLabel);
		LostPane.getChildren().add(CurrentScoreLabel);
		
		
		
		
	}
	
	public void updateScoreLabels(int currentScore) {
		CurrentScore = currentScore;
		ScoreList.add(CurrentScore);
		computeHighestScore();
		
		
		HighScoreLabel.setText("High Score: " + HighScore + "");
		CurrentScoreLabel.setText("Current Score " + CurrentScore + "");
		
		
		
	}
	
	public void setStartScreen(StartScreen start) {
		starter = start;
	}
	
	
	public void addScoreToList(int Score) {
		ScoreList.add(Score);
		
	}
	
	private void computeHighestScore() {
		
		for (int score = 0; score < ScoreList.size(); score++) {
			if ((int)ScoreList.get(score) > HighScore) {
				HighScore = (int)ScoreList.get(score);
			}
			
		
			
			
			
		}
		
	}
	
	
	
	
	
	
	
	
}
