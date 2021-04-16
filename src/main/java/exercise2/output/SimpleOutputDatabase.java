package exercise2.output;

import exercise2.HibernateUtil;
import exercise2.objects.SaveObject;
import exercise2.objects.Task;
import exercise2.objects.User;
import org.hibernate.Session;

public class SimpleOutputDatabase implements Output {
    @Override
    public void output(SaveObject myObject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            myObject.getTasks().forEach(session::save);
            myObject.getUsers().forEach(session::save);
        } catch (Exception e) {

        }
        session.close();
    }
}
