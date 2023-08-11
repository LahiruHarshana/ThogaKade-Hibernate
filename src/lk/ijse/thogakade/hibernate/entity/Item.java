package lk.ijse.thogakade.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "item")
public class Item {
    @Id
    @Column(name = "code",length = 30)
    String itemCode;
    @Column(name = "Item_description",nullable = false)
    String ItemDescription;
    @Column(name = "ItemPrice",nullable = false)
    Double price;
    @Column(name = "ItemQty",nullable = false)
    Integer qty;

    @ManyToMany(mappedBy = "items")
    List<Orders> orders = new ArrayList<>();

    public Item(String itemCode, String itemDescription, Double price, Integer qty) {
        this.itemCode = itemCode;
        this.ItemDescription = itemDescription;
        this.price = price;
        this.qty = qty;
    }

    public Item() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", ItemDescription='" + ItemDescription + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", orders=" + orders +
                '}';
    }
}
