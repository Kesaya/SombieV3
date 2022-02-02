package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			initSombie();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void initSombie() {
		System.out.println("Initializing SOMBIE V3");
		parseIngredients(); //parse Ingredients first, as they are needed for Cocktails
		parseCocktails(); //parse Cocktails second as they are needed for the finalState
		parseConfiguration(); // load the current State e.g. and Configuration
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private static void parseIngredients() {
		System.out.println("Parsing Ingredients...");
		IngredientParser ingredientParser = new IngredientParser();
		ingredientParser.parse();
	}
	
	private static void parseCocktails() {
		System.out.println("Parsing Cocktails...");
		CocktailParser cocktailParser = new CocktailParser();
		cocktailParser.parse();
	}
	
	private static void parseConfiguration() {}
}
