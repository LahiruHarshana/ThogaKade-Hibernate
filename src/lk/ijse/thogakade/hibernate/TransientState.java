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

        System.out.println(session.contains(customer));

    }

    private String isExistsInSession(Session session ,Customer customer){
       return session.contains(customer)?"Customer mapped with a session " : "Customer not mapped with session";
    }

}
