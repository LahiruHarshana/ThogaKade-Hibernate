package lk.ijse.thogakade.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "item_id")
    private int id;
    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_quantity")
    private int qty;
    @Column(name="unit_price")
    private double unitPrice;

    }
}
