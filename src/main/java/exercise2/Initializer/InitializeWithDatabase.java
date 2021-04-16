package exercise2.Initializer;

import exercise2.HibernateUtil;
import exercise2.objects.SaveObject;
import exercise2.objects.Task;
import exercise2.objects.User;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class InitializeWithDatabase implements InitializerFile {
    @Override
    public SaveObject initialize() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//
//            Query query = session.createQuery("SELECT c FROM Country c");
//            List<User> countries = query.getResultList();
//
//            countries.stream().forEach((x) -> System.out.println(x));
//
//            Query query2 = session.createQuery("SELECT DISTINCT cont FROM "
//                    + "Continent cont JOIN cont.countries t WHERE cont.name='Europe'");
//            Continent europe_cont = (Continent) query2.getSingleResult();
//
//            System.out.println(europe_cont);
//
//            session.getTransaction().commit();
//        } catch (Exception e) {
//
//        }
//        HibernateUtil.shutdown();
//        return null;
//    }


//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
//
//            User user1 = new User();
//            user1.setFirstName("firstName1");
//            user1.setLastName("lastName1");
//            User user2 = new User();
//            user2.setFirstName("firstName12");
//            user2.setLastName("lastName2");
//            user2.setUserName("userName2");
//
//            Task task1 = new Task();
//            task1.setTaskTitle("task1");
//            task1.setTaskTitle("do task1");
//            task1.setUser();
//
//        }
//        HibernateUtil.shutdown();
        return null;
    }
}
