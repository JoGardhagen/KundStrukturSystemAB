package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
/*CRM demo 
 * kunder , säljare och produter laddas in från textFiler.
 * många buggar existerar i programmet. . . 
 * grafer o Listor finns med.
 * Exporterings till en fil. 
 * */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainSheet.fxml"));
			Scene scene = new Scene(root,700,585);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);// gör att användaren inte kan ändra storleken på Applikations Fönstret
			primaryStage.setTitle("CRM-Demo");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
