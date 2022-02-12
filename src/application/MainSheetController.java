package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.CustomersBuyings;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.FillCustomerFromFile;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.ActivityStage;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.FillSellerFromFile;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.FillSellersCostumerList;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;
import com.gardhagen.joakim.kundStrukturSystemAB.products.Article;
import com.gardhagen.joakim.kundStrukturSystemAB.products.FillPruductList;
import com.gardhagen.joakim.kundStrukturSystemAB.products.UnitsIntHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainSheetController implements Initializable {
	@FXML
	ComboBox<Seller> selectSeller;
	@FXML
	ComboBox<Article> selectArticle;
	@FXML
	Label SellerInfo, CustomerInfo, sellingsInformation;
	@FXML
	ListView<Customer> customerListView;
	@FXML
	Button sellbutton, activityListButton, customerBuyings;
	@FXML
	TextField units;

	List<Customer> CustemerList = new ArrayList<>();
	List<Seller> SellerList = new ArrayList<>();
	List<Article> PruductList = new ArrayList<>();
	FillSellerFromFile FSFF = new FillSellerFromFile(SellerList);
	FillPruductList FPL = new FillPruductList(PruductList);

	FillCustomerFromFile FCFF = new FillCustomerFromFile(CustemerList);
	FillSellersCostumerList FSCL = new FillSellersCostumerList(SellerList, CustemerList);
	ObservableList<Seller> sellers = FXCollections.observableArrayList(SellerList);

	ObservableList<Article> pruducts = FXCollections.observableArrayList(PruductList);

	@FXML
	void sellToCustomer(ActionEvent event) {
		try {
			UnitsIntHandler.getIntFromTextField(units);
			try {
				sellingsInformation.setText(UnitsIntHandler.getIntFromTextField(units) + " "
						+ selectArticle.getSelectionModel().getSelectedItem().toString() + " Sells to "
						+ customerListView.getSelectionModel().getSelectedItem().toString() + " for :"
						+ selectArticle.getSelectionModel().getSelectedItem().price
								* UnitsIntHandler.getIntFromTextField(units)
						+ " SEK:-");
				selectSeller.getSelectionModel().getSelectedItem().activityList.add(sellingsInformation.getText());
				customerListView.getSelectionModel().getSelectedItem()
					.bought.add(selectArticle.getSelectionModel().getSelectedItem().toString());
			} catch (Exception e) {
				sellingsInformation.setText("Not Product or Customer is Chosen");
			}
		} catch (Exception e) {
			sellingsInformation.setText("Put int a Nummber in Units");
		}

	}

	@FXML
	void Select(ActionEvent event) {
		String s = selectSeller.getSelectionModel().getSelectedItem().toString();
		SellerInfo.setText(s);
		System.out.println(selectSeller.getSelectionModel().getSelectedItem().sellersCustomerList);
		customerListView.getItems().clear();
		customerListView.getItems().addAll(selectSeller.getSelectionModel().getSelectedItem().sellersCustomerList);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		selectSeller.setItems(sellers);// Populerar försäljare till ComboBox för Försäljare
		selectArticle.setItems(pruducts);

	}

	@FXML
	void printActivityList() {

		try {// Öppnar ett popup med aktivitetsLista
			new ActivityStage(selectSeller.getSelectionModel().getSelectedItem());
		} catch (Exception e) {
			SellerInfo.setText("No Staff Member Chosen");
		}

	}
	@FXML
	void printCustomersBuyings() {
		try {
			new CustomersBuyings(customerListView.getSelectionModel().getSelectedItem());
			CustomerInfo.setText("CustomerInfo");
		} catch (Exception e) {
			CustomerInfo.setText("No Customer Chosen");
		}
	}

}
