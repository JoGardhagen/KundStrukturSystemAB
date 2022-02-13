package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.gardhagen.joakim.kundStrukturSystemAB.export.Export;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.CustomersBuyings;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.FillCustomerFromFile;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.ActivityStage;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.FillSellerFromFile;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.FillSellersCostumerList;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;
import com.gardhagen.joakim.kundStrukturSystemAB.products.Article;
import com.gardhagen.joakim.kundStrukturSystemAB.products.ArticleStatistics;
import com.gardhagen.joakim.kundStrukturSystemAB.products.FillPruductList;
import com.gardhagen.joakim.kundStrukturSystemAB.products.UnitsIntHandler;
import com.gardhagen.joakim.kundStrukturSystemAB.sellingsOverTime.SellingsOverTime;
import com.gardhagen.joakim.kundStrukturSystemAB.timeStamp.TimeStamp;

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
	Label SellerInfo, CustomerInfo, sellingsInformation, commonCustomerLable, target, targetCustomer, targetArticle,
			exportTarget;
	@FXML
	ListView<Customer> customerListView;
	@FXML
	Button sellbutton, activityListButton, customerBuyings, articleStatistics, sellings, exportData;
	@FXML
	TextField units;

	List<Customer> CustemerList = new ArrayList<>();
	List<Seller> SellerList = new ArrayList<>();
	List<Article> PruductList = new ArrayList<>();
	FillSellerFromFile FSFF = new FillSellerFromFile(SellerList);
	FillPruductList FPL = new FillPruductList(PruductList);
	TimeStamp timeStamp = new TimeStamp();
	FillCustomerFromFile FCFF = new FillCustomerFromFile(CustemerList);
	FillSellersCostumerList FSCL = new FillSellersCostumerList(SellerList, CustemerList);
	ObservableList<Seller> sellers = FXCollections.observableArrayList(SellerList);

	ObservableList<Article> pruducts = FXCollections.observableArrayList(PruductList);

	@FXML
	void sellToCustomer(ActionEvent event) {
		TimeStamp timeStamp = new TimeStamp();
		String date = timeStamp.toString();
		try {
			commonCustomerLable.setText(" ");
			UnitsIntHandler.getIntFromTextField(units);
			try {
				sellingsInformation
						.setText(
								UnitsIntHandler.getIntFromTextField(units) + " "
										+ selectArticle.getSelectionModel().getSelectedItem().toString() + " Sells to "
										+ customerListView.getSelectionModel().getSelectedItem().toString() + " for : "
										+ selectArticle.getSelectionModel().getSelectedItem().price
												* UnitsIntHandler.getIntFromTextField(units)
										+ " SEK:- " + date.toString());
				selectSeller.getSelectionModel().getSelectedItem().activityList.add(sellingsInformation.getText());
				for (Seller seller : sellers) {
					for (Customer customer : seller.sellersCustomerList) {
						if (customer.equals(customerListView.getSelectionModel().getSelectedItem())) {
							seller.setCommonCustomer(true);
							commonCustomerLable
									.setText(customerListView.getSelectionModel().getSelectedItem().toString()
											+ "is Common Customer with Seller " + seller.getForName().toString() + " "
											+ seller.getLastName().toString());
							System.out.println("noted");
						}
					}
				}
				customerListView.getSelectionModel().getSelectedItem().bought.add(sellingsInformation.getText());
				selectArticle.getSelectionModel().getSelectedItem().sold.add(sellingsInformation.getText());

			} catch (Exception e) {
				sellingsInformation.setText("Not Product or Customer is Chosen");
			}
		} catch (Exception e) {
			sellingsInformation.setText("Put int a Nummber in Units");
		}

	}

	@FXML
	void Select(ActionEvent event) {// styr combobox valen för Försäljare
		String s = selectSeller.getSelectionModel().getSelectedItem().toString();
		SellerInfo.setText(s);
		customerListView.getItems().clear();
		customerListView.getItems().addAll(selectSeller.getSelectionModel().getSelectedItem().sellersCustomerList);
		target.setText(s);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		selectSeller.setItems(sellers);// Populerar försäljare till ComboBox för Försäljare
		selectArticle.setItems(pruducts);// Populerar producter till Artikel Comboboxen

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

		try {// Öppnar ett popup med Lista som visar vad kunden köpt
			new CustomersBuyings(customerListView.getSelectionModel().getSelectedItem());
			CustomerInfo.setText("CustomerInfo");
		} catch (Exception e) {
			CustomerInfo.setText("No Customer Chosen");
		}
	}

	@FXML
	void articleStatistics() {
		try {// Öppnar ett popup med List som visar var varan sålts
			new ArticleStatistics(selectArticle.getSelectionModel().getSelectedItem());
		} catch (Exception e) {
			sellingsInformation.setText("No Article Chosen");
		}
	}

	@FXML
	void showSellings() {// graf popup
		try {
			new SellingsOverTime(selectSeller.getSelectionModel().getSelectedItem());
		} catch (Exception e) {
			target.setText("No Seller Chosen");
		}
	}

	@FXML
	void exportDataHandler() {
		try {
			Export export = Export.getInstance();// tillhör singelton mönster är loggfil som uppdateras
			for (String s : selectSeller.getSelectionModel().getSelectedItem().activityList) {
				try {
					export.printExport(s);
				} catch (Exception e) {}
			}
		} catch (Exception e) {
			exportTarget.setText("No Seller Chosen");
		}

	}

}
