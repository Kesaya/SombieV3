package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.shape.Circle;

public class MainMenuController {
	
	@FXML
	public Button btn_Cocktails;
	public Button btn_Mix;
	public Button btn_Ingredients;

	public MainMenuController() {
		// TODO Auto-generated constructor stub
		System.out.println("Initializy Main Menu Controller...");
		
	}
	
	
	public void btnCocktailsClicked(ActionEvent e) {
		System.out.println("Cocktails Clicked");
	}
	
	public void btnMixClicked(ActionEvent e) {
		System.out.println("Mix Clicked");
	}
	
	public void btnIngredientsClicked(ActionEvent e) {
		System.out.println("Ingredients Clicked");
	}
	
	
}
