package lk.ijse.thogakade.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "Item_Code" ,length = 255)
    private String itemCode;
    @Column(name = "Item_Description")
    private String description;
    @Column(name = "Item_Price")
    private double price;
    @Column(name = "Item_Qty")
    private int qty;

    public Item() {
    }

    public Item(String itemCode, String description, double price, int qty) {

        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.qty = qty;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
