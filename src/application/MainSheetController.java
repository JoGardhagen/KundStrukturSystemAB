package application;

import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MainSheetController {
	@FXML
	ComboBox<Seller> selectSeller;
	@FXML
	ComboBox<Customer> selectCustomer;
	@FXML
	Label SellerInfo,CustomerInfo;
}
