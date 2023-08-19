package lk.ijse.thogakade.hibernate;

import lk.ijse.thogakade.hibernate.entity.Customer;

public class TransientState {
    public static void main(String[] args) {
        //Transient
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");

    }

}
