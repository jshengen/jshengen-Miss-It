package screen;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SettingsScene extends SubScene {

	
	private static Pane SettingsPane;
	private String BackgroundURL;
	private TextField MovementSpeed;
	private TextField ObstacleSpeed;
	private TextField ObstacleAmount;
	private SettingsLabel MovementSpeedLabel;
	private SettingsLabel ObstacleSpeedLabel;
	private SettingsLabel ObstacleAmountLabel;
	private SettingsButton ConfirmSettings;

	private double MovementSpeedX;
	private double ObstacleSpeedX;
	private double ObstacleAmountX;
	private double MovementSpeedY;
	private double ObstacleSpeedY;
	private double ObstacleAmountY;
	
	private boolean DefaultSettings = true;
	private boolean DefaultMoveSpeed = true;
	private boolean DefaultObstacleSpeed = true;
	private boolean DefaultObstacleCreationSpeed = true;
	
	private double moveSpeed;
	private double maxObstacleSpeed;
	private double obstacleCreationSpeed;
	
	private double defaultMoveSpeed = .5;
	private double defaultMaxObstacleSpeed = .05;
	private double defaultObstacleCreationSpeed = .01;
	
	
	private double SceneWidth;
	private double SceneHeight;
	private double TextFieldWidth = 35;
	private double TextFieldHeight = 20;
	
	private Background redBack = new Background(new BackgroundFill(Color.RED,null,null));
	private Background whiteBack = new Background(new BackgroundFill(Color.WHITE,null,null));

	
	
	private double FontSize = 16;
	
	
	public SettingsScene(double width, double height) {
		super(SettingsPane = new Pane(), width, height);
		SettingsPane.setPrefSize(width, height);
		SceneWidth = width;
		SceneHeight = height;
		
		createTextFields();
		createTextFieldLabels();
		createConfirmSettingsButton();
		
		
	}
	
	private void calculateTextX() {
		
	}
	
	private void calculateTextY() {
		
	}
	
	

	private void createTextFields() {
		MovementSpeed = new TextField();
		ObstacleSpeed = new TextField();
		ObstacleAmount = new TextField();
		
		MovementSpeed.setPrefSize(TextFieldWidth, TextFieldHeight);
		ObstacleSpeed.setPrefSize(TextFieldWidth, TextFieldHeight);
		ObstacleAmount.setPrefSize(TextFieldWidth, TextFieldHeight);
		
		MovementSpeed.setLayoutX(SceneWidth - (TextFieldWidth + 10));
		ObstacleSpeed.setLayoutX(SceneWidth - (TextFieldWidth + 10));
		ObstacleAmount.setLayoutX(SceneWidth - (TextFieldWidth + 10));
		
		MovementSpeed.setLayoutY(30);
		ObstacleSpeed.setLayoutY((SceneHeight/2)- .5 * TextFieldHeight);
		ObstacleAmount.setLayoutY(SceneHeight - (TextFieldHeight + 30));
		
		
		
		SettingsPane.getChildren().add(MovementSpeed);
		SettingsPane.getChildren().add(ObstacleSpeed);
		SettingsPane.getChildren().add(ObstacleAmount);
		
		}
	
	private void createTextFieldLabels() {
		MovementSpeedLabel = new SettingsLabel();
		ObstacleSpeedLabel = new SettingsLabel();
		ObstacleAmountLabel = new SettingsLabel();
		
		MovementSpeedLabel.setText("Movement Speed");
		ObstacleSpeedLabel.setText("Max Obstacle Movement Speed");
		ObstacleAmountLabel.setText("Obstacle Creation Speed");
		
		MovementSpeedLabel.setFont(new Font(FontSize));
		ObstacleSpeedLabel.setFont(new Font(FontSize));
		ObstacleAmountLabel.setFont(new Font(FontSize));
		
		MovementSpeedLabel.setLayoutX(0);
		ObstacleSpeedLabel.setLayoutX(0);
		ObstacleAmountLabel.setLayoutX(0);
		
		MovementSpeedLabel.setLayoutY(30);
		ObstacleSpeedLabel.setLayoutY((SceneHeight/2)- .5 * TextFieldHeight);
		ObstacleAmountLabel.setLayoutY(SceneHeight - (TextFieldHeight + 30));
		
		SettingsPane.getChildren().add(MovementSpeedLabel);
		SettingsPane.getChildren().add(ObstacleSpeedLabel);
		SettingsPane.getChildren().add(ObstacleAmountLabel);
		
	}
	
	
	private void createConfirmSettingsButton() {
		ConfirmSettings = new SettingsButton();
		ConfirmSettings.setText("Confirm Settings");
		ConfirmSettings.setLayoutX(110);
		ConfirmSettings.setLayoutY(150);
		
		ConfirmSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				setMovementSpeed();
				setMaxObstacleSpeed();
				setObstacleAmount();
				//if (DefaultMoveSpeed == false && DefaultObstacleSpeed == false && DefaultObstacleCreationSpeed == false) {
				
				//}
			
				
			}
			
		});
		
		
		
		
		SettingsPane.getChildren().add(ConfirmSettings);
		
	}
	
	
	
	public void setMovementSpeed() { //put in error catch
	try {
		moveSpeed = Double.parseDouble(MovementSpeed.getText());
		MovementSpeed.setBackground(whiteBack);
		DefaultMoveSpeed = false;
		

	} catch(Exception e){
		MovementSpeed.setBackground(redBack);
	}
	
	}
	

	public void setMaxObstacleSpeed() { //put in error catch
		try {
			maxObstacleSpeed = Double.parseDouble(ObstacleSpeed.getText());
			ObstacleSpeed.setBackground(whiteBack);
			DefaultObstacleSpeed = false;

		} catch(Exception e){
			ObstacleSpeed.setBackground(redBack);
			
		}
	
	}
	

	public void setObstacleAmount() { //put in error catch
		try {
			obstacleCreationSpeed = Double.parseDouble(ObstacleAmount.getText());
			ObstacleAmount.setBackground(whiteBack);
			DefaultObstacleCreationSpeed = false;

		} catch(Exception e){
			ObstacleAmount.setBackground(redBack);
		}
	
	}
	
	public double getMovementSpeed() {
		
		if (DefaultMoveSpeed == true) {
			moveSpeed = defaultMoveSpeed;
		}
		
		return moveSpeed;
		
	}
	
	public double getObstacleSpeed() {
		
		if (DefaultObstacleSpeed == true) {
			maxObstacleSpeed = defaultMaxObstacleSpeed;
		}
		return maxObstacleSpeed;
		
	}
	public double getObstacleCreationSpeed() {
	
		if (DefaultObstacleCreationSpeed == true) {
			obstacleCreationSpeed = defaultObstacleCreationSpeed;
		}
		return obstacleCreationSpeed;
	}
	
	
	
	
	
	
	
}
