package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
/*CRM demo 
 * kunder , s�ljare och produter laddas in fr�n textFiler.
 * m�nga buggar existerar i programmet. . . 
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
			primaryStage.setResizable(false);// g�r att anv�ndaren inte kan �ndra storleken p� Applikations F�nstret
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
