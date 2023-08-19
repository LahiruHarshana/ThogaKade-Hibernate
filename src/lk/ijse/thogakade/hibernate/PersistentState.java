package lk.ijse.thogakade.hibernate;

import lk.ijse.thogakade.hibernate.config.SessionFactoryConfig;
import lk.ijse.thogakade.hibernate.entity.Customer;
import org.hibernate.Session;

public class PersistentState {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        //Transient
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");
        //persistence
        int custId = (int)session.save(customer);


        System.out.println(session.contains(customer));
    }
}
