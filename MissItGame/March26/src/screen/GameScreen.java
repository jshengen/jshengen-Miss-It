package screen;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ObstacleHeightStorage;
import model.ObstacleURLStorage;
import model.ObstacleWidthStorage;
import model.ShipHeightStorage;
import model.ShipURLStorage;
import model.ShipWidthStorage;

public class GameScreen {
	
	//Initialize the root used for the game scene
	private Pane GamePane;
	//initialize the scene used for the game
	private Scene GameScene;
	//initialize the stage used
	private Stage GameStage;
	//Set the height of the start screen
	private final int HEIGHT = 800;
	//Set the width of the start screen
	private final int WIDTH = 600;

	private Stage MenuStage;

	private Ship MainShip;
	private double MainShipX;
	private double MainShipY;
	
	private String Ship1URL = ShipURLStorage.SHIP1.getURL();;
	private double Ship1Width = ShipWidthStorage.SHIP1.getWidth();
	private double Ship1Height = ShipHeightStorage.SHIP1.getHeight();
	
	private String Obstacle1URL = ObstacleURLStorage.OBSTACLE1.getURL();
	private double Obstacle1Width = ObstacleWidthStorage.OBSTACLE1.getWidth();
	private double Obstacle1Height = ObstacleHeightStorage.OBSTACLE1.getHeight();
	
	private List<Obstacles> ObstacleList;
	
	private AnimationTimer GameTimer;
	
	private String BackgroundURL = "model/resources/cat.png";
	
	private static Stage LostStage = null;
	
	private int Score;
	
	private ScoreScreen ScoreScreen;
	
	 
	private boolean FirstTime;
	
	private double PlayerMoveSpeed;
	
	private double MaxObstacleMoveSpeed;
	
	private double ObstacleCreationSpeed;
	
	private StartScreen startScreen;
	
	private LostScreen lostScreen;
	
	private GameScreen gameScreen;
	
	private boolean IsCollision;
	
	private List<KeyCode> UpKey;
	private List<KeyCode> DownKey;
	private List<KeyCode> Up_DownKey;
	//private List<KeyCode>
	//private List<KeyCode>
	
	
	
	private List<KeyCode> KeysPressed;
	
	//Set the default constructor to set up the scene when called
	public GameScreen(boolean firstRun, double moveSpeed) {
		
		PlayerMoveSpeed = moveSpeed;
		GamePane = new Pane();
		GamePane.setPrefSize(WIDTH, HEIGHT);
		GamePane.setMaxSize(WIDTH, HEIGHT);
		GamePane.setMinSize(WIDTH, HEIGHT);
		GameScene = new Scene(GamePane,WIDTH,HEIGHT);
		GameStage = new Stage();
		
		UpKey = new ArrayList();
		DownKey = new ArrayList();
		Up_DownKey = new ArrayList();
		
		UpKey.add(KeyCode.UP);
		DownKey.add(KeyCode.DOWN);
		Up_DownKey.add(KeyCode.UP);
		Up_DownKey.add(KeyCode.DOWN);
		
		setBackground();
	
		placeShip(Ship1URL, Ship1Width, Ship1Height);
		
		IsCollision = false;
		
		KeysPressed = new ArrayList<KeyCode>();
		ObstacleList = new ArrayList<Obstacles>();
		
		setUpScore();
		createListeners();
	
		placeObstacle();
		
		
		
		GameStage.setScene(GameScene);
		
		createGameLoop();
		
		
		FirstTime = firstRun;
		
	}
	
	public double getHEIGHT() {
		return HEIGHT;
	}
	
	public void setGameScreen(GameScreen GameSCreen) {
		gameScreen = GameSCreen;
	}
	
	public double getWIDTH() {
		return WIDTH;
	}
	
	public Stage getGameStage() {
		return GameStage;
	}
	
	public void startNewGame(Stage MenuStage ) {
		this.MenuStage = MenuStage;
		this.MenuStage.hide();
		GameStage.show();
		lostScreen = new LostScreen(this.MenuStage, Score);
	}
	
	public void startNewGame(Stage MenuStage, LostScreen loser ) {
		lostScreen = loser;
		this.MenuStage = MenuStage;
		this.MenuStage.hide();
		GameStage.show();
		
		
	}
	
	public double getPlayerMoveSpeed() {
		return PlayerMoveSpeed;
	}
	
	public double getMaxObstacleMoveSpeed() {
		return MaxObstacleMoveSpeed;
	}
	public double getObstacleCreationSpeed() {
		return ObstacleCreationSpeed;
	}
	
	public void setPlayerMoveSpeed(double moveSpeed) {
		PlayerMoveSpeed = moveSpeed;
	}
	
	public void setObstacleMoveSpeed(double obstacleSpeed) {
		MaxObstacleMoveSpeed = obstacleSpeed;
	}
	public void setObstacleCreationSpeed(double obstacleCreateSpeed) {
		ObstacleCreationSpeed = obstacleCreateSpeed;
	}
	
	
	
	public void setLostScreen(LostScreen loser) {
		lostScreen = loser;
		
	}
	
	
	private void placeShip(String URL, double shipWidth, double shipHeight ) {
		MainShip = new Ship(URL,shipWidth, shipHeight);
		MainShipX = MainShip.startShipX( WIDTH);
		MainShipY = MainShip.startShipY( HEIGHT); 
		MainShip.setMoveAmount(PlayerMoveSpeed);
		
		MainShip.setLayoutX(MainShipX);
	
		MainShip.setLayoutY(MainShipY);
		
		GamePane.getChildren().add(MainShip);
		
	}
	
	private void placeObstacle() {
		Obstacles obstacle = new Obstacles(Obstacle1URL,Obstacle1Width,Obstacle1Height);
		obstacle.setMaxMoveSpeed(MaxObstacleMoveSpeed);
		obstacle.placeObstacle(WIDTH, HEIGHT);
		GamePane.getChildren().add(obstacle);
		ObstacleList.add(obstacle);
		
		
		
	}
	
	
	
	private void moveObstacles() {
		for(Obstacles i : ObstacleList) {
			i.moveObstacle();
		}
	}
	
	
	private void setBackground() {
		
		BackgroundImage back = new BackgroundImage(new Image(BackgroundURL, WIDTH, HEIGHT,false,false),
				BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,null );
		
		Background background = new Background(back);
		
		GamePane.setBackground(background);
	}
	
	
	private void setUpScore() {
		int Width = 80;
		int Height = 60;
		double xCoordinate = WIDTH - (Width + 10);
		double yCoordinate = HEIGHT - (Height + 10);
		
		
		
		ScoreScreen = new ScoreScreen(Width, Height );
		
		GamePane.getChildren().add(ScoreScreen);
		
		ScoreScreen.setLayoutX(xCoordinate);
		ScoreScreen.setLayoutY(yCoordinate); 
		
		
		
	}
	
	
	
	
	
	
	
	
	
	private void createListeners() {
		GameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
					if (event.getCode() == KeyCode.LEFT ) {
				
						if(KeysPressed.contains(KeyCode.LEFT) == false) {
						KeysPressed.add(KeyCode.LEFT);
						}
						
						
					}
					else if (event.getCode() == KeyCode.RIGHT) {
			
						if(KeysPressed.contains(KeyCode.RIGHT) == false) {
						KeysPressed.add(KeyCode.RIGHT);
						}
		
					}
					else if (event.getCode() == KeyCode.UP) {
			
						if(KeysPressed.contains(KeyCode.UP) == false) {
						KeysPressed.add(KeyCode.UP);
						}
	
					}
					else if (event.getCode() == KeyCode.DOWN) {
						
						if(KeysPressed.contains(KeyCode.DOWN) == false) {
						KeysPressed.add(KeyCode.DOWN);
						}

					}
					
					
					
					
					
				}
				
			}
			
		}
	);
		
		GameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
					if (event.getCode() == KeyCode.LEFT ) {
						KeysPressed.remove(KeyCode.LEFT);
						
					}
					
					 if (event.getCode() == KeyCode.RIGHT) {
						KeysPressed.remove(KeyCode.RIGHT);
					}
					if (event.getCode() == KeyCode.UP) {
						KeysPressed.remove(KeyCode.UP);
					}
					 if (event.getCode() == KeyCode.DOWN) {
						KeysPressed.remove(KeyCode.DOWN);
					}
				}
	
			}
			
		});
	}
	
	private void createGameLoop() {
		
		Score = 0;
		
		GameTimer = new AnimationTimer() {
			int k = 0;
			double test = 400;
			@Override
			public void handle(long now) {
				moveShip();
				MainShip.updatePosition();
				if (KeysPressed.equals(UpKey) || KeysPressed.equals(DownKey) || KeysPressed.isEmpty()) {
					MainShip.noInput();
				}
				if (k == (int)test) {
				placeObstacle();
				}
				moveObstacles();
				
				checkCollision();
				
				k = (int) (k % test);
				k++;
				if (test>25 && test > ObstacleCreationSpeed) {
				test = test - ObstacleCreationSpeed;
				}
				if (test < 0) {
					test = 1;
				}
			
				if (IsCollision == true) {
					GameTimer.stop();
					
					if(FirstTime == true) {
					//lostScreen = new LostScreen(MenuStage, Score);
					lostScreen.showLostStage();
					lostScreen.setStartScreen(startScreen);
					LostStage = lostScreen.getStage();
					lostScreen.setStartScreen(startScreen);
					lostScreen.setGameScreen(gameScreen);
					lostScreen.setLostScreen(lostScreen);
					lostScreen.updateScoreLabels(Score);
					
					}
					else if (FirstTime == false) {
					
						lostScreen.updateScoreLabels(Score);
						LostStage.show();
						
					}
					GameStage.hide();
					
				}
				ScoreScreen.setScore(Score);
				Score ++;
				

			}
			
		};
		
		GameTimer.start();
		
	}
	
	
	private void moveShip() {
		//if(KeysPressed.contains(KeyCode.LEFT) || KeysPressed.contains(KeyCode.RIGHT) || 
			//	KeysPressed.contains(KeyCode.DOWN) || KeysPressed.contains(KeyCode.UP)) {
			
		/*
		 * if (KeysPressed.contains(KeyCode.LEFT) && KeysPressed.contains(KeyCode.RIGHT)
		 * && KeysPressed.contains(KeyCode.DOWN) && KeysPressed.contains(KeyCode.UP)) {
		 * MainShip.noInput(); } else if (KeysPressed.contains(KeyCode.LEFT) &&
		 * KeysPressed.contains(KeyCode.RIGHT) && KeysPressed.contains(KeyCode.DOWN)) {
		 * MainShip.moveDown(); } else if (KeysPressed.contains(KeyCode.LEFT) &&
		 * KeysPressed.contains(KeyCode.RIGHT) && KeysPressed.contains(KeyCode.UP)) {
		 * MainShip.moveUp(); }
		 * 
		 * else if (KeysPressed.contains(KeyCode.LEFT) &&
		 * KeysPressed.contains(KeyCode.DOWN) && KeysPressed.contains(KeyCode.UP)) {
		 * MainShip.moveLeft();
		 * 
		 * } else if ( KeysPressed.contains(KeyCode.RIGHT) &&
		 * KeysPressed.contains(KeyCode.DOWN) && KeysPressed.contains(KeyCode.UP)) {
		 * MainShip.moveRight(); } else
		 */ if (KeysPressed.contains(KeyCode.LEFT) && KeysPressed.contains(KeyCode.RIGHT)) {
				MainShip.noInput();
			}
			
			else if (KeysPressed.contains(KeyCode.UP) && KeysPressed.contains(KeyCode.DOWN)) {
				MainShip.noInput();
			}
			else if (KeysPressed.contains(KeyCode.LEFT) && KeysPressed.contains(KeyCode.UP)) {
				MainShip.moveLeft();
				MainShip.moveUp();
			}
			else if (KeysPressed.contains(KeyCode.LEFT) && KeysPressed.contains(KeyCode.DOWN)) {
				MainShip.moveLeft();
				MainShip.moveDown();
			}
			else if (KeysPressed.contains(KeyCode.RIGHT) && KeysPressed.contains(KeyCode.UP)) {
				MainShip.moveRight();
				MainShip.moveUp();
			}
			else if (KeysPressed.contains(KeyCode.RIGHT) && KeysPressed.contains(KeyCode.DOWN)) {
				MainShip.moveRight();
				MainShip.moveDown();
			}
			else if (KeysPressed.contains(KeyCode.LEFT) && KeysPressed.contains(KeyCode.UP)) {
				MainShip.moveLeft();
				MainShip.moveUp();
			}
			else if ( KeysPressed.contains(KeyCode.UP)) {

				MainShip.moveUp();
			}
			else if ( KeysPressed.contains(KeyCode.DOWN)) {

				MainShip.moveDown();
			}
			else if ( KeysPressed.contains(KeyCode.LEFT)) {

				MainShip.moveLeft();
			}
			else if ( KeysPressed.contains(KeyCode.RIGHT)) {

				MainShip.moveRight();
			}
		 
		MainShipX = MainShip.getLayoutX();
		MainShipY = MainShip.getLayoutY();
			
			
			
			
			
			
		//}
	}
	
	public void setLostStage(Stage lostSTage) {
		LostStage = lostSTage;
	}
	
	
	public void setStart(StartScreen start) {
		startScreen = start;
	}
	
	private void checkCollision() {
		for (Obstacles obstacle : ObstacleList) {
			

			
			if(obstacle.getBoundsInParent().intersects(MainShip.getBoundsInParent()) ) {
				IsCollision = true;
			}
					
		}
	}	
	
}
