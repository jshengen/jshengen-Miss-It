package screen;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.PlayButton;


public class StartScreen {

	
	private AnchorPane MainPane;
	private Scene MainScene;
	private Stage MainStage;
	private final int WIDTH = 1200;
	private final int HEIGHT = 800;
	private final int BUTTON_STARTX = 50;
	private final int BUTTON_STARTY = 100;
	private List <PlayButton> ButtonList;
	private List <ImageView> LogoList;
	private AnimationTimer LogoTime;
	private String BackgroundURL = "screen/resources/startScreenBackground.jpeg";
	private String LogoURL = "screen/resources/MissIt.png";
	private String Logo2URL = "screen/resources/MissIt2.png";
	private String Logo3URL = "screen/resources/MissIt3.png";

	private GameScreen GameScreen;
	
	private LostScreen lostScreen;
	
	private StartScreen startScreen;
	
	private static Stage LostStage;
	
	private boolean FirstTime;
	
	
	
	
	
	public StartScreen() {
		ButtonList = new ArrayList<PlayButton>();
		LogoList = new ArrayList<ImageView>();
		fillLogoList();
		MainPane = new AnchorPane();
		MainScene = new Scene(MainPane,WIDTH,HEIGHT);
		MainStage = new Stage();
		MainStage.setScene(MainScene);
		
		createBackground();
		createButtons();
		animateLogo();
		FirstTime = true;
		
	}
	
	public Stage getMainStage() {
		return MainStage;
	}
	
	public void setStartScreen(StartScreen start) {
		startScreen = start;
	}
	
	private void addMenuButton(PlayButton button) {
	
		button.setLayoutX(BUTTON_STARTX);
		button.setLayoutY(BUTTON_STARTY + (200 * ButtonList.size()));
		ButtonList.add(button);
		MainPane.getChildren().add(button);
		
	}
	
	
	private void createButtons() {
		createStartButton();
		createCreditsButton();
		createScoreButton();
	}
	
	public void setLostStage(Stage lostStage) {
		LostStage = lostStage;
	}
	
	public void setLostScreen(LostScreen loser) {
		lostScreen = loser;
		
	}
	
	
	private void createStartButton() {
		PlayButton startButton = new PlayButton("PLAY");
		startButton.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				if(FirstTime == true) {
				GameScreen gameScreen = new GameScreen(true);
				GameScreen = gameScreen;
				gameScreen.startNewGame(MainStage);
				//LogoTime.stop();
				FirstTime = false;
				gameScreen.setStart(startScreen);
				gameScreen.setGameScreen(gameScreen);
				}
				else if(FirstTime == false) {
					GameScreen gameScreen = new GameScreen(false);
					GameScreen = gameScreen;
					gameScreen.startNewGame(MainStage, lostScreen);
					//LogoTime.stop();
				}
				
				
			}		
		});
				
		addMenuButton(startButton);
	
	}
	
	private void createCreditsButton() {
		PlayButton creditsButton = new PlayButton("CREDITS");
		addMenuButton(creditsButton);
		
	}
	
	private void createScoreButton() {
		PlayButton scoreButton = new PlayButton("SCORE");
		addMenuButton(scoreButton);
		
	}
	
	private void createBackground() {
		Image backgroundImage = new Image(BackgroundURL, 1920, 1200,  true , false);
		BackgroundImage background = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null );
		MainPane.setBackground(new Background(background));
		
	}
	
	
	
	
	private void animateLogo() {
	
		LogoTime = new AnimationTimer() {
		int i = 0;
		int k = 0;
		int test = 20;
		
		ImageView bob;
			@Override
			public void handle(long now) {
				
				MainPane.getChildren().remove(bob);
				
				MainPane.getChildren().add(LogoList.get(i));
				
				
				bob = LogoList.get(i);
				k ++;
				
				if (k == test) {
					i = i + 1;
					i = i % 3;	
					
				}
				
				k = k % test;
			}
			
		};
		LogoTime.start();
	}
	
	
	
	private void fillLogoList() {
		ImageView logo = new ImageView(LogoURL);
		ImageView logo2 = new ImageView(Logo2URL);
		ImageView logo3 = new ImageView(Logo3URL);
		logo.setLayoutX(600);
		logo.setLayoutY(100);
		logo2.setLayoutX(600);
		logo2.setLayoutY(100);
		logo3.setLayoutX(600);
		logo3.setLayoutY(100);	
		
		LogoList.add(0,logo);
		LogoList.add(1,logo2);
		LogoList.add(2,logo3);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
