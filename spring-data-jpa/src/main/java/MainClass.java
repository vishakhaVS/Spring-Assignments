
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import repository.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 3.Perform all the methods inside CrudRepository for Person Class.
 * 5.Use the methods declared above to fetch the person.
 */
public class MainClass {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        PersonRepository personRepository = (PersonRepository) context.getBean("personRepository");

//      Question3
//      Using save(S entity)
        System.out.println("=====================Single Record Added=====================");
        System.out.println(personRepository
                .save(new Person("vishakha", "sharma", 24, 450000)));

//      Using save(Iterable<S> entities)
        List<Person> people = Arrays.asList(new Person("vishakha", "sharma", 25, 430000),
                new Person("harshita", "jain", 25, 420000),
                new Person("fName", "lName", 24, 420000),
                new Person("Peter", "parker", 26, 410000));
        System.out.println("=====================Multiple Records Added=====================");
        personRepository.save(people).forEach(System.out::println);

//      Using findOne(ID id)
        System.out.println("=====================Find one with id 1=====================");
        System.out.println(personRepository.findOne(1));

//      Using exists(ID id)
        System.out.println("=====================Exists with id 1=====================");
        System.out.println(personRepository.exists(1));

//      Using findAll()
        System.out.println("=====================Find All Records=====================");
        personRepository.findAll().forEach(System.out::println);

//      Using findAll(Iterable<ID> ids)
        System.out.println("=====================Find All Records having ids 2,3,4=====================");
        personRepository.findAll(people.stream().map(Person::getId).collect(Collectors.toList()))
                .forEach(System.out::println);

//      Using count()
        System.out.println("No. of Persons : " + personRepository.count());

//      Using delete(ID id)
        System.out.println("=====================Delete with id 4=====================");
        personRepository.delete(4);
        personRepository.findAll().forEach(System.out::println);

//      Using delete(T entity)
        System.out.println("=====================Delete with id 1=====================");
        personRepository.delete(personRepository.findById(1));
        personRepository.findAll().forEach(System.out::println);

//      Using delete(Iterable<? extends T> entities)
        System.out.println("=====================Delete using iterable with id 2,3=====================");
        personRepository.delete(Arrays.asList(people.get(0), people.get(1)));
        personRepository.findAll().forEach(System.out::println);

//      Using deleteAll()
        System.out.println("=====================Delete All=====================");
        personRepository.deleteAll();
        personRepository.findAll().forEach(System.out::println);

        personRepository.save(people);

//      Question5
        System.out.println("Person with Id 6 : " + personRepository.findById(6));
        System.out.println("Persons with FirstName vishakha : " + personRepository.findByFirstName("vishakha"));
        System.out.println("Persons with lastName sharma : " + personRepository.findByLastName("sharma"));


//      Question 6
        System.out.println("Persons with age = 25 : " + personRepository.findByAgeViaQuery());

//      Question7
        System.out.println("Persons full Name with age = 25 : ");
        personRepository.findFullNameWithAge25ViaQuery().forEach(System.out::println);

//      Question8
        System.out.println("Persons with age = 25 : ");
        personRepository.findPersonWithAgeViaQuery().forEach(System.out::println);

//      Question9
        System.out.println("Persons with first Name = Peter : " + personRepository.findPersonWithNamePeterViaQuery());

//      Question10
        System.out.println("Persons with age = 25, Using count : " + personRepository.countAllByAge(25));

        System.out.println("Persons with age = 26 or firstName = vishakha, Using distinct : " + personRepository
                .getDistinctByFirstNameOrAge("vishakha", 26));

        System.out.println("Persons with age = 25 and firstName = vishakha, Using distinct : " + personRepository
                .getAllByFirstNameAndAge("vishakha", 25));

        System.out.println("Persons age between 25 and 28= vishakha, Using distinct : " + personRepository
                .getByAgeBetween(25, 28));

        System.out.println("Persons salary less than 420000 : " + personRepository
                .getBySalaryLessThan(420000));

        System.out.println("Persons salary greater than 420000 : " + personRepository
                .getBySalaryGreaterThan(420000));

        System.out.println("Persons with name like vishakha : " + personRepository
                .getByFirstNameLike("vishakkha"));

        System.out.println("Persons with name not like vishakha : " + personRepository
                .getByFirstNameNot("vishakha"));

        System.out.println("Persons with name not like vishakha : " + personRepository
                .getByFirstNameIn(Arrays.asList("vishakha", "harshita")));

        System.out.println("Persons with name VISHAKHA ignoring case : " + personRepository
                .getByFirstNameIgnoreCase("VISHAKHA"));

//      Question11
        System.out.println("Persons with age greater than 25 sorted by descending order by id : " + personRepository
                .findByAgeGreaterThanOrderByIdDesc(25));

//      Question12
        System.out.println("Persons with age greater than 25 sorted by descending order by id using sort class : "
                + personRepository.findByAgeGreaterThan(25, new Sort(Sort.Direction.DESC, "id")));

//      Question13
        Page<Person> personPage = personRepository.findAll((new PageRequest(0, 2)));
        System.out.println("Paginated Persons : " + personPage);
        System.out.println(personPage.getContent());

    }
}