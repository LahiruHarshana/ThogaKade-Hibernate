package lk.ijse.thogakade.hibernate.entity;

import lk.ijse.thogakade.hibernate.embeded.OrderDetailPK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "oder_details")
public class Order_Detail {
    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    @Column(name = "order_quantity")
    private int qty;
    @Column(name = "order_price")
    private double price;


}
