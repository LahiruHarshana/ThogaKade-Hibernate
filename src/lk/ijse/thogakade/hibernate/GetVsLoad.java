package lk.ijse.thogakade.hibernate;

import lk.ijse.thogakade.hibernate.config.SessionFactoryConfig;
import lk.ijse.thogakade.hibernate.entity.Customer;
import org.hibernate.Session;

public class GetVsLoad {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig
                .getInstance().getSession();
        int cusId = (int) session.save(getCustomer());
        session.close();

        // 1. Get
        Session session2 = SessionFactoryConfig
                .getInstance().getSession();
        System.out.println("------------Get--------------");
        Customer get = session2.get(Customer.class, 2);
        System.out.println("Customer Id of Get: " +get.getId());
        System.out.println("Customer Name of Get: " +get.getName());
        session2.close();

        // 2. Load
        Session session3 = SessionFactoryConfig
                .getInstance().getSession();
        System.out.println("----------Load-------------");
        Customer load = session3.load(Customer.class, 2);
        System.out.println("Customer Id of Load: " +load.getId());
        System.out.println("Customer Name of Load: " +load.getName());

        session3.close();
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");
        return customer;
    }
}
