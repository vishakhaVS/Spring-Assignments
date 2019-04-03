package repository;

import entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    //Question4
    List<Person> findByfName(String fName);

    List<Person> findBylName(String lName);

    Person findById(Integer id);


    //Question6

    @Query("select fName from Person where age=25")
    List<Person> findByAge();


    //Question7
    @Query("select CONCAT(p.fName, ' ' ,p.lName) from Person p where age=25")
    List<String> findfNameAndlName();

    //Question8
    @Query("select (p)from Person p where age=25")
    List<Person>findPersonDetails();

  //Question9
    @Query("select count(p) from Person p where fName='peter'")
    int findCount();


    //Question10

    List<Person> getDistinctByfNameOrAge(String fName, Integer age);


    List<Person> getAllByFNameAndAge(String fName, Integer age);

    List<Person> getByAgeBetween(Integer min, Integer max);

  List<Person> getBySalaryLessThan(Integer salary);

    List<Person> getBySalaryGreaterThan(Integer salary);

    List<Person> getByAgeLike(Integer age);

    List<Person> getByAgeNot(Integer age);

     List<Person> getByfNameIn(List<String> fName);

    List<Person> getBylNameIgnoreCase(String lName);

    //Question11
    List<Person> getByAgeGreaterThanOrderByIdDesc(Integer age);

    //Question12
    List<Person> findByAgeGreaterThan(Integer age, Sort sort);


    //Question13
    Page<Person> findAll(Pageable pageable);

}
