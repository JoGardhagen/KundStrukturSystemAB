package application;



import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.FillCustomerFromFile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MainSheetController implements Initializable{
	@FXML
	ComboBox<Customer> selectSeller;
	@FXML
	ComboBox<Customer> selectCustomer;
	@FXML
	Label SellerInfo,CustomerInfo;
	Customer cust = new Customer(0,"Joakim","Gårdhagen","Skeppartorpsvägen 14");
	List <Customer> CustemerList = new ArrayList<>();
	FillCustomerFromFile FFF = new FillCustomerFromFile(CustemerList);
	ObservableList<Customer> listA = FXCollections.observableArrayList(CustemerList);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		selectSeller.setItems(listA);
		selectCustomer.setItems(listA);
	}
	
}
