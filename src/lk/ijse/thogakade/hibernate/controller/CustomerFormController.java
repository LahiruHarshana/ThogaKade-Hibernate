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

        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction trans = session.beginTransaction();

        String id = (cstId.getText());
        Customer customer = session.get(Customer.class,id);    }

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

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = customerRepository.getCustomer(cstId.getText());



    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
}
