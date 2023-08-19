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
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");
        return customer;
    }
}
