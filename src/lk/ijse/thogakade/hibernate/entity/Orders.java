package lk.ijse.thogakade.hibernate.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @Column(name = "order_id")
    private String id;
    @Column(name = "order_description")
    private String desc;
    @CreationTimestamp
    @Column(name = "order_date")
    private Timestamp orderDateTime;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    public Orders() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Timestamp orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", orderDateTime=" + orderDateTime +
                '}';
    }

    public Orders(String id, String desc, Timestamp orderDateTime) {
        this.id = id;
        this.desc = desc;
        this.orderDateTime = orderDateTime;
    }

}
