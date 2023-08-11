package lk.ijse.thogakade.hibernate.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(schema = "orders")
public class Orders {

    @Id
    @Column(name = "orders_id",length = 30)
    String id;
    @Column(name = "order_date",nullable = false)
    Date date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_detail",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "code")
    )
    List<Item> items;

    public Orders() {
    }

    public Orders(String id, Date date, List<Item> items) {
        this.id = id;
        this.date = date;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", items=" + items +
                '}';
    }
}