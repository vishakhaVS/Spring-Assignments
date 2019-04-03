package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    int id;
    String fName;
    String lName;
    int salary;
    int age;


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String fName, String lName, int salary, int age, int id) {
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.age = age;
        this.id = id;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
