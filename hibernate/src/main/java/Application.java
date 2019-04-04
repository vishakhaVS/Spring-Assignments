import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Date;

public class Application {
    public static void main(String[] args) {


        //CRUD CREATE
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Author("Vishakha", "Sharma", 24, 1));
        session.save(new Author("Yatin", "ajmani", 24, 2));
        session.save(new Author("sid", "gupta", 12, 3));
        session.save(new Author("fname", "lname", 78, 4));
        session.save(new Author("updateName", "updateLName", 87, 5));


        System.out.println("=====CRUD CREATE======");
        System.out.println(Arrays.asList(session.get(Author.class, 1), session.get(Author.class, 2), session.get(Author.class, 3), session.get(Author.class, 4), session.get(Author.class, 5)));

        //CRUD READ
        System.out.println("=======Reading id 1=======");
        Author author = session.get(Author.class, 1);
        session.getTransaction().commit();
        System.out.println(author);

        //CRUD UPDATE
        session.beginTransaction();
        author.setFirstName("Updated Name");
        author.setLastName("Updated last name");
        author.setAge(80);
        session.update(author);
        session.getTransaction().commit();

        System.out.println("======CRUD UPDATE======");
        System.out.println(author);

        //CRUD DELETE
       /* Author person=session.get(Author.class,2);
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
        session.close();
        System.out.println("===============CRUD DELETE=====================");
        System.out.println(person);*/

        //Question13
        session.beginTransaction();

        Author author1 = session.get(Author.class, 1);

        author1.setSubjects(Arrays.asList("TOC", "DAA", "PPM", "SE"));

        session.save(author1);

        session.getTransaction().commit();
        System.out.println("=====Question13=====");
        System.out.println(session.get(Author.class, 1));

        System.out.println("====Question15=====");

     /*   Author authorMapping=new Author();
        Book book=new Book();
        book.setId(1);
        book.setBookName("RK Sharma");
        authorMapping.setFirstName("Heena");
        authorMapping.setLastName("singh");
        authorMapping.setAge(30);
        authorMapping.setBook(book);
        session.save(book);
        session.save(authorMapping);
        //System.out.println(session.get(Author.class,1));
        session.close();*/

        //Question16
        Author authorMapping = new Author();
        Author authorMapping1 = new Author();
        Book book = new Book();

        authorMapping.setFirstName("Teena");
        authorMapping.setLastName("singh");
        authorMapping.setAge(30);
        authorMapping1.setFirstName("yatin");
        authorMapping1.setLastName("ajmani");
        authorMapping1.setAge(40);
        book.setBookName("pk Garg");
        book.getAuthor().add(authorMapping);
        book.getAuthor().add(authorMapping1);

        //Questionbidirectional
        authorMapping.setBook(book);

        session.beginTransaction();
        session.save(authorMapping);
        session.save(authorMapping1);
        session.save(book);
        session.getTransaction().commit();
        session.close();

    }

}