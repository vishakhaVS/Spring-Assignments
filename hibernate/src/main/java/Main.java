import entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setFirstName("Vishakha");
        author.setLastName("Sharma");
        author.setAge(24);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();

        Author person = session.get(Author.class, 1);
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        System.out.println(person); //Read


        //SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        //Session session=sessionFactory.openSession();
        session.beginTransaction();
        Author person1=session.get(Author.class,1);
        person1.setFirstName("Updated Name");
        person1.setLastName("Updated Name");
        person1.setAge(20);
        session.update(person);
        session.getTransaction().commit();
        session.close();
        System.out.println(person); //update
        

    }
    }


