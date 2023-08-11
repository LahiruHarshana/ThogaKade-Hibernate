package lk.ijse.thogakade.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.thogakade.hibernate.config.SessionFactoryConfig;
import lk.ijse.thogakade.hibernate.entity.Customer;
import lk.ijse.thogakade.hibernate.repository.CustomerRepository;
import lk.ijse.thogakade.hibernate.view.TM.CustomerTM;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAd;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TextField cstAd;

    @FXML
    private TextField cstId;

    @FXML
    private TextField cstName;

    @FXML
    private TableView<CustomerTM> cstTbl;

    @FXML
    private ImageView imgHome;

    @FXML
    private AnchorPane root;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        CustomerRepository customerRepository = new CustomerRepository();
        Customer existingCustomer = customerRepository.getCustomer(cstId.getText());
        boolean isDeleted = customerRepository.deleteCustomer(existingCustomer);
        if (isDeleted) {
            System.out.println("Customer Deleted!");
        } else {
            System.out.println("Customer Deletion Failed!");
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Customer customer = new Customer(cstId.getText(),cstName.getText(),cstAd.getText());
        CustomerRepository cusRepository = new CustomerRepository();
        String savedCusId = cusRepository.saveCustomer(customer);
        System.out.println("Saved Cus Id: " + savedCusId);
        LoadTable();

    }


    @FXML
    void btnSearchOnAction(ActionEvent event) {
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository = new CustomerRepository();
        Customer existingCustomer = customerRepository.getCustomer(cstId.getText());
        cstId.setText(existingCustomer.getId());
        cstName.setText(existingCustomer.getName());
        cstAd.setText(existingCustomer.getAddress());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        CustomerRepository customerRepository = new CustomerRepository();
        Customer existingCustomer = customerRepository.getCustomer(cstId.getText());
        existingCustomer.setAddress(cstAd.getText());
        existingCustomer.setName(cstName.getText());
        existingCustomer.setId(cstId.getText());
        boolean isUpdated = customerRepository.updateCustomer(existingCustomer);
        if (isUpdated) {
            System.out.println("Customer Updated!");
        } else {
            System.out.println("Customer Update Failed!");
        }

    }

    void LoadTable(){
        try {
            CustomerRepository customerRepository = new CustomerRepository();
            ObservableList<CustomerTM> obList = FXCollections.observableArrayList();
            List<Customer> cusList = customerRepository.getAll();

            for (Customer customer : cusList) {
                obList.add(new CustomerTM(
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress()
                ));
            }
            cstTbl.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadTable();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAd.setCellValueFactory(new PropertyValueFactory<>("address"));
    }
}
