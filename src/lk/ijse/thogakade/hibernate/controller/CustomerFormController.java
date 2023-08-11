package lk.ijse.thogakade.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.thogakade.hibernate.config.SessionFactoryConfig;
import lk.ijse.thogakade.hibernate.entity.Customer;
import lk.ijse.thogakade.hibernate.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerFormController {

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
    private TableView<Customer> cstTbl;

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
}
