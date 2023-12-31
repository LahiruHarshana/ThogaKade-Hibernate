package lk.ijse.thogakade.hibernate;

import lk.ijse.thogakade.hibernate.config.SessionFactoryConfig;
import lk.ijse.thogakade.hibernate.entity.Customer;
import org.hibernate.Session;

public class TransientState {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();
        //Transient
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");

        System.out.println(isExistsInSession(session,customer));

    }

    private static String isExistsInSession(Session session, Customer customer){
       return session.contains(customer)?"This object is not transient" : "This object is transient";
    }



}
