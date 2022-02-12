package application;

import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ActivityStage {
	
	public ActivityStage(Seller seller) {
		Stage activityStage = new Stage();
		activityStage.setTitle("Activity List for " + seller.getForName() + " "+seller.getLastName());
		StackPane layout = new StackPane();
		ListView<String> listview = new ListView<>();
		addSellerList(seller, listview);
		layout.getChildren().add(listview);
		Scene scene = new Scene(layout,600,400);
		activityStage.setScene(scene);
		activityStage.show();
	}
	void addSellerList(Seller seller,ListView<String> listview) {
		for(String s : seller.activityList) {
			listview.getItems().add(s);
		}
		
	}
	
}
