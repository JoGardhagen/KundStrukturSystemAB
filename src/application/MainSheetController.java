package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.FillCustomerFromFile;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.FillSellerFromFile;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.FillSellersCostumerList;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;
import com.gardhagen.joakim.kundStrukturSystemAB.products.Article;
import com.gardhagen.joakim.kundStrukturSystemAB.products.FillPruductList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainSheetController implements Initializable{
	@FXML
	ComboBox<Seller> selectSeller;
	@FXML
	ComboBox<Article> selectArticle;
	@FXML
	Label SellerInfo,CustomerInfo,sellingsInformation;
	@FXML
	ListView<Customer>customerListView;
	@FXML
	Button sellbutton;
	
	List <Customer> CustemerList = new ArrayList<>();
	List <Seller> SellerList = new ArrayList<>();
	List <Article> PruductList = new ArrayList<>();
	FillSellerFromFile FSFF = new FillSellerFromFile(SellerList);
	FillPruductList FPL = new FillPruductList(PruductList);

	FillCustomerFromFile FCFF = new FillCustomerFromFile(CustemerList);
	FillSellersCostumerList FSCL=new FillSellersCostumerList(SellerList,CustemerList);
	ObservableList<Seller> sellers = FXCollections.observableArrayList(SellerList);

	ObservableList<Article> pruducts = FXCollections.observableArrayList(PruductList);
	
	@FXML
	void sellToCustomer(ActionEvent event) {
		try {
			sellingsInformation.setText(selectArticle.getSelectionModel().getSelectedItem().toString()+" Sells to "+customerListView.getSelectionModel().getSelectedItem().toString());
		} catch (Exception e) {
			sellingsInformation.setText("ingen product eller kund vald");
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
	
}
