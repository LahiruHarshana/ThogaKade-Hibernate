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

    @ManyToOne
    @JoinColumn(name="item_id",
                insertable = false,
                updatable = false)
    private Item item;

    public Order_Detail() {
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Order_Detail{" +
                "orderDetailPK=" + orderDetailPK +
                ", qty=" + qty +
                ", price=" + price +
                ", orders=" + orders +
                ", item=" + item +
                '}';
    }

    public Order_Detail(OrderDetailPK orderDetailPK, int qty, double price, Orders orders, Item item) {
        this.orderDetailPK = orderDetailPK;
        this.qty = qty;
        this.price = price;
        this.orders = orders;
        this.item = item;
    }
}
