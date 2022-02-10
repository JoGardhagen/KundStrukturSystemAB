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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MainSheetController implements Initializable{
	@FXML
	ComboBox<Seller> selectSeller;
	@FXML
	ComboBox<Customer> selectCustomer;
	@FXML
	Label SellerInfo,CustomerInfo;
	
	List <Customer> CustemerList = new ArrayList<>();
	List <Seller> SellerList = new ArrayList<>();
	FillSellerFromFile FSFF = new FillSellerFromFile(SellerList);
//	FillCustomerFromFile FCFF = new FillCustomerFromFile(SellerList);
	FillCustomerFromFile FCFF = new FillCustomerFromFile(CustemerList);
	FillSellersCostumerList FSCL=new FillSellersCostumerList(SellerList,CustemerList);
	ObservableList<Seller> sellers = FXCollections.observableArrayList(SellerList);
	
	
	@FXML
	void Select(ActionEvent event) {
		String s = selectSeller.getSelectionModel().getSelectedItem().toString();
		SellerInfo.setText(s);
		ObservableList<Customer> customers = FXCollections.observableArrayList(selectSeller.getSelectionModel().getSelectedItem().sellersCustomerList);
		selectCustomer.setItems(customers);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
////		selectSeller.setItems(listA);
//		Collections.shuffle(customers);
		selectSeller.setItems(sellers);
		
//		if(selectSeller.equals(SellerList.get(1))) {
//			selectCustomer.setItems((ObservableList<Customer>) SellerList.get(1).sellersCustomerList);
//		}
		
		
	}
	
}
