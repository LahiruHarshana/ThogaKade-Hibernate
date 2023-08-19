package lk.ijse.thogakade.hibernate.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Table(name = "order_detail")
public class OrderDetailPK implements Serializable {
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "item_id")
    private int itemId;

    public OrderDetailPK() {
    }

    public OrderDetailPK(int orderId, int itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "OrderDetailPK{" +
                "orderId=" + orderId +
                ", itemId=" + itemId +
                '}';
    }
}
