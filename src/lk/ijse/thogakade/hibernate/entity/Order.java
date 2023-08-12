package lk.ijse.thogakade.hibernate.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @Column(name = "order_id")
    private String id;
    @Column(name = "order_description")
    private String desc;
    @CreationTimestamp
    @Column(name = "order_date")
    private Timestamp orderDateTime;


    public Order() {
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

    public Order(String id, String desc, Timestamp orderDateTime) {
        this.id = id;
        this.desc = desc;
        this.orderDateTime = orderDateTime;
    }

}
