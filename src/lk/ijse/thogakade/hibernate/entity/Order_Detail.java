package lk.ijse.thogakade.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "oder_details")
public class Order_Detail {
    @Column(name = "order_quantity")
    private int qty;
    @Column(name = "order_price")
    private double price;


}
