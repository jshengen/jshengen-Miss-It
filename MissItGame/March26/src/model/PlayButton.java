package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class PlayButton extends Button{

	private final String FONT_PATH = "src/model/resources/CaviarDreams.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/StartButtonPressed.png');";
	private final String BUTTON_NORMAL_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/StartButtonNormal.png');";
	private int PressedHeight = 112;
	private int PressedWidth = 382;
	private int NormalHeight = 116;
	private int NormalWidth = 387;
	private int FontSize = 58;
	
	
	
	
	public PlayButton(String text) {
		setText(text);
		setButtonFont();
		setPrefHeight(NormalHeight);
		setPrefWidth(NormalWidth);
		setStyle(BUTTON_NORMAL_STYLE);
		initializeButtonListeners();
	}
	
	private void setButtonFont() {
		
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), FontSize));
		}
		catch (FileNotFoundException e) {
			setFont(Font.font("Verdanna", FontSize));
		}
	}
	
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefWidth(PressedWidth);
		setPrefHeight(PressedHeight);
		setLayoutX(getLayoutX() + (NormalWidth - PressedWidth));
		setLayoutY(getLayoutY() - (NormalHeight - PressedHeight));
		
	}
	
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_NORMAL_STYLE);
		setPrefWidth(NormalWidth);
		setPrefHeight(NormalHeight);
		setLayoutX(getLayoutX() - (NormalWidth - PressedWidth));
		setLayoutY(getLayoutY() + (NormalHeight - PressedHeight));
	}
	
	private void initializeButtonListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
				
			}
			
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}
				
			}
			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());
				
			}
			
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
				
			}
			
		});
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
