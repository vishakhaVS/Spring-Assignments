package entity;


import javax.persistence.*;
import java.util.*;


@Entity
public class Author {

    //Question9
    // @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Identity")
    int id;

    @Column(name = "first_name")
    private String firstName;

    //Question7
    @Transient
    private String lastName;
    private int age;

    //Question8
    @Temporal(TemporalType.DATE)
    private Date Date_Of_Birth;


    //Question11
    @Embedded
    private Address address;

    //Question12
    @ElementCollection
    private
    List<String> subjects = new ArrayList<>();



    //Question15
   /* @OneToOne
    @JoinColumn(name = "join_book_column")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }*/




//Question16,17
    @ManyToOne
    Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    //Question17
//     @ManyToMany
//    List<Book> books= new ArrayList<Book>();

//
//
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Author() {

    }

    public Author(String firstName, String lastName, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

//    public Author(String firstName, String lastName, int age, Date date_Of_Birth, Address address, List<String> subjects, Book book) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        Date_Of_Birth = date_Of_Birth;
//        this.address = address;
//        this.subjects = subjects;
//        this.book = book;
//    }
//
//    @Override
//    public String toString() {
//        return "Author{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                ", Date_Of_Birth=" + Date_Of_Birth +
//                ", address=" + address +
//                ", subjects=" + subjects +
//                ", book=" + book +
//                '}';
//    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", Date_Of_Birth=" + Date_Of_Birth +
                ", address=" + address +
                ", subjects=" + subjects +
                '}';
    }
}

