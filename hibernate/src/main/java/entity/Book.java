package entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
//Question17
    private String bookName;
/*
    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book() {
    }

    //Question16
//     @JoinTable
//    @OneToMany(cascade = CascadeType.PERSIST)

//bidirectional
    @OneToMany(mappedBy = "book")
//    @JoinTable(joinColumns = @JoinColumn(name="author_id")
//            ,inverseJoinColumns = @JoinColumn(name = "book_id"))
    private
    Collection<Author> author= new HashSet<Author>();

    public Collection<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Collection<Author> author) {
        this.author = author;
    }
    /*   public Book(String bookName, List<Author> authors) {
        this.bookName = bookName;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authors=" + authors +
                '}';
    }*/

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                '}';
    }
}