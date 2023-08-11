package lk.ijse.thogakade.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.thogakade.hibernate.entity.Customer;
import lk.ijse.thogakade.hibernate.entity.Item;
import lk.ijse.thogakade.hibernate.repository.CustomerRepository;
import lk.ijse.thogakade.hibernate.repository.ItemRepository;

public class ItemsFormController {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDes;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private ImageView imgHome;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblItems;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtItemDes;

    @FXML
    private TextField txtItemUnit;

    @FXML
    private TextField txtQty;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();
        Item existingCustomer = itemRepository.getItem(txtItemCode.getText());
        boolean isDeleted = itemRepository.deleteItem(existingCustomer);
        if (isDeleted) {
            System.out.println("Customer Deleted!");
        } else {
            System.out.println("Customer Deletion Failed!");
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Item item = new Item(txtItemCode.getText(),txtItemDes.getText(),Double.valueOf(txtItemUnit.getText()),Integer.parseInt(txtQty.getText()));
        ItemRepository itemRepository = new ItemRepository();
        String saveItemCode = itemRepository.saveItem(item);
        System.out.println("Saved Cus Id: " + saveItemCode);

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();
        itemRepository = new ItemRepository();
        Item existingCustomer = itemRepository.getItem(txtItemCode.getText());
        txtItemCode.setText(existingCustomer.getItemCode());
        txtItemDes.setText(existingCustomer.getDescription());
        txtItemUnit.setText(String.valueOf(existingCustomer.getPrice()));
        txtQty.setText(String.valueOf(existingCustomer.getQty()));

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event){
        ItemRepository itemRepository = new ItemRepository();
        Item existingCustomer = itemRepository.getItem(txtItemCode.getText());
        existingCustomer.setDescription(txtItemDes.getText());
        existingCustomer.setItemCode(txtItemCode.getText());
        existingCustomer.setPrice(Double.parseDouble(txtItemUnit.getText()));
        existingCustomer.setQty(Integer.parseInt(txtQty.getText()));
        boolean isUpdated = itemRepository.updateItem(existingCustomer);
        if (isUpdated) {
            System.out.println("Customer Updated!");
        } else {
            System.out.println("Customer Update Failed!");
        }

    }

}
