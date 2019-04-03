import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import repository.PersonRepository;

import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonRepository personRepository = (PersonRepository) ctx.getBean("personRepository");
        //Question3

        System.out.println("Added record");
        System.out.println(personRepository
                .save(new Person("Vishakha", "sharma", 10000, 24, 1)));

        System.out.println("find One");
        System.out.println(personRepository.findOne(1));
        System.out.println("Exists");
        System.out.println(personRepository.exists(1));


        List<Person> people = Arrays.asList(new Person("mehak", "adlakha", 25000, 20, 2),
                new Person("sid", "gupta", 15000, 25, 3),
                new Person("peter", "parker", 30000, 18, 4),
                new Person("REETIKA", "TYAGI", 10000, 29, 5));
        personRepository.save(people).forEach(System.out::println);

        System.out.println("FIND ALL");
        personRepository.findAll().forEach(System.out::println);

        System.out.println("Count of Person");
        System.out.println(personRepository.count());

        System.out.println("DELETE ALL");
        /*personRepository.deleteAll();
        personRepository.findAll().forEach(System.out::println);
        personRepository.save(people);*/

        //Question5
        System.out.println("Person with Id 1");
        System.out.println(personRepository.findById(1));


        System.out.println("FirstName with vishakha");
        System.out.println(personRepository.findByfName("vishakha"));

        System.out.println("LastName with sharma");
        System.out.println(personRepository.findBylName("sharma"));

        //Question6
        System.out.println("====First Name with Age 25=======");
        System.out.println(personRepository.findByAge());


        //Question7
        System.out.println("====First Name And Last Name with Age 25");
        System.out.println(personRepository.findfNameAndlName());

        //Question8
        System.out.println("Person Full details with age 25");
        System.out.println(personRepository.findPersonDetails());

        //Question9
        System.out.println("Count of Peter");
        System.out.println(personRepository.findCount());

            //Question10
        System.out.println("=====Distinct by name or Age======");
        System.out.println(personRepository.getDistinctByfNameOrAge("Vishakha",25));
        System.out.println("=====All By name And Age====");
        System.out.println(personRepository.getAllByFNameAndAge("Vishakha",24));
        System.out.println("====Age Between====");
        System.out.println(personRepository.getByAgeBetween(18,24));
        System.out.println("====Salary Less than====");
        System.out.println(personRepository.getBySalaryLessThan(25000));
        System.out.println("======Salary Greater Than=====");
        System.out.println(personRepository.getBySalaryGreaterThan(25000));
        System.out.println("====Like====");
        System.out.println(personRepository.getByAgeLike(24));
        System.out.println("===Not===");
        System.out.println(personRepository.getByAgeNot(18));
        System.out.println("===IN===");
        System.out.println(personRepository.getByfNameIn(Arrays.asList("Vishakha","sid")));
        System.out.println("IGNORE CASE");
        System.out.println(personRepository.getBylNameIgnoreCase("tyagi"));

        System.out.println("Question11");
        System.out.println(personRepository.getByAgeGreaterThanOrderByIdDesc(20));

        System.out.println("Question12");
        System.out.println(personRepository.findByAgeGreaterThan(25, new Sort(Sort.Direction.DESC, "id")));

        System.out.println("Question 13");
        Page<Person> personPage = personRepository.findAll((new PageRequest(0, 3,new Sort(Sort.Direction.DESC, "id"))));
        System.out.println(personPage);
        System.out.println(personPage.getContent());


    }
}
