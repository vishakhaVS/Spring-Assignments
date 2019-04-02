package repository;


import entity.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Question2
public interface PersonRepository extends CrudRepository<Person, Integer> {

    //Person findByAge(Integer age);
    List<Person> findFirstByFirstName(String name);


    @Query("SELECT firstName,lastName from Person  where age=25")
    List<Object[]> findByAge();


    //Question4
    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    Person findById(Integer id);


    //Question6
    @Query("select firstName from Person where age=25")
    List<Person> findByAgeViaQuery();


    //Question7
    @Query("select CONCAT(p.firstName, ' ', p.lastName) as fullname from Person p where age=25")
    List<String> findFullNameWithAge25ViaQuery();

    // Question8
    @Query("from Person where age=25")
    List<Person> findPersonWithAgeViaQuery();

    //  Question9
    @Query("select count(p) from Person p where firstName='Peter'")
    Integer findPersonWithNamePeterViaQuery();

    //Question10
    Integer countAllByAge(Integer age);

    List<Person> getDistinctByFirstNameOrAge(String fName, Integer age);

    List<Person> getAllByFirstNameAndAge(String fName, Integer age);

    List<Person> getByAgeBetween(Integer after, Integer before);

    List<Person> getBySalaryLessThan(Integer salary);

    List<Person> getBySalaryGreaterThan(Integer salary);

    List<Person> getByFirstNameLike(String firstName);

    List<Person> getByFirstNameNot(String firstName);

    List<Person> getByFirstNameIn(List<String> firstNames);

    List<Person> getByFirstNameIgnoreCase(String firstName);

    // Question11
    List<Person> findByAgeGreaterThanOrderByIdDesc(Integer age);

    //Question12
    List<Person> findByAgeGreaterThan(Integer age, Sort sort);

    //Question13
    Page<Person> findAll(Pageable pageable);
}




