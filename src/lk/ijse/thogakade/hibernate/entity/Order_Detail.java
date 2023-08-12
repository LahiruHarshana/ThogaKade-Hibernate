package lk.ijse.thogakade.hibernate.entity;

import lk.ijse.thogakade.hibernate.embeded.OrderDetailPK;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class Order_Detail {
    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    @Column(name = "order_quantity")
    private int qty;
    @Column(name = "order_price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id",
                referencedColumnName = "order_id",
                insertable = false,
                updatable = false)
    private Orders orders;

    private Item item;



}
