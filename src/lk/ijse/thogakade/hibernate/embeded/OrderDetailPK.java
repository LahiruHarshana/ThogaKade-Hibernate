package lk.ijse.thogakade.hibernate.embeded;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPK {
    private int orderId;
    private int itemId;
}
