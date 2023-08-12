//package lk.ijse.thogakade.hibernate.repository;
//
//import lk.ijse.thogakade.hibernate.config.SessionFactoryConfig;
//import lk.ijse.thogakade.hibernate.entity.Customer;
//import lk.ijse.thogakade.hibernate.entity.Item;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class ItemRepository {
//    private Session session;
//    public ItemRepository(){
//        session = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//    }
//    public Item getItem(String code){
//        try {
//            return session.get(Item.class,code);
//        }catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }
//    }
//
//    public String saveItem(Item item){
////        session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            String id =(String)session.save(item);
//            transaction.commit();
//            session.close();
//            return id;
//        }catch (Exception e){
//            transaction.rollback();
//            session.close();
//            e.printStackTrace();
//            return "false";
//        }
//    }
//    public boolean updateItem(Item item){
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.update(item);
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            session.close();
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//
//    public boolean deleteItem(Item item){
//        Transaction transaction = session.beginTransaction();
//        try{
//            session.delete(item);
//            transaction.commit();
//            session.close();
//            return true;
//
//        }catch (Exception e){
//            transaction.rollback();
//            session.close();
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
