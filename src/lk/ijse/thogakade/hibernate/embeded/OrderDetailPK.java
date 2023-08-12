package lk.ijse.thogakade.hibernate.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPK {
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "item_id")
    private int itemId;



}
