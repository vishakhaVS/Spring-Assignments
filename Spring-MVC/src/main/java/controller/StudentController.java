package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/*Question1*/
/*public class StudentController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("hello");
        ModelAndView mnv= new ModelAndView("index");
        return mnv;


    }

}*/




/*Question2*/

/*
public class StudentController extends MultiActionController {

    public ModelAndView Multi1(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return new ModelAndView("multi1");
    }
    public void Multi2(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.getWriter().print("response from httpservlet response");
    }
}
*/

@Controller
public class StudentController {


    //    Question3
    @RequestMapping("/")
    ModelAndView index() {
        ModelAndView mnv = new ModelAndView("index");
        return mnv;
    }


    /*Question4*/
    @RequestMapping("/hello")
    @ResponseBody
    String response() {
        return "Hello World";
    }


    /*Question5*/
    @RequestMapping("/message")
    @ResponseBody
    ModelAndView index_message() {
        ModelAndView mnv2 = new ModelAndView("index");
        mnv2.addObject("msz", "HelloWorld");
        return mnv2;
    }

    /*Question6*/
    /*@RequestMapping("/Name/{FirstName}/{LastName}")
    @ResponseBody
    String name(@PathVariable("FirstName") String FirstName, @PathVariable("LastName") String LastName)
    {
            return FirstName + LastName;
    }*/

    /*Question7*/

    /*@RequestMapping("/Name/{FirstName}/{LastName}")
    @ResponseBody
    String nameAndLastname(@PathVariable Map<String,String> map)
    {
        return map.get("FirstName") + " " + map.get("LastName");
    }*/

    /*Question8*/
    @RequestMapping(value = "/formData", method = RequestMethod.GET)
    @ResponseBody
    String submitForm(@RequestParam("username") String username,
                      @RequestParam("password") String password) {
        return "Username " + username + " Password " + password;
    }

/*Question9*/
    @RequestMapping(value = "/submittedData", method = RequestMethod.POST)
    @ResponseBody
    String submittedData(StudentCO studentCO) {
        return studentCO.getfName() + studentCO.getlName();

    }


    /*Question10*/
    @ModelAttribute
    void addingObject(Model model){
        model.addAttribute("heading","SPRING MVC DEMO");
    }

}

class StudentCO {
    String fName;
    String lName;

    public StudentCO(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

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

    public StudentCO() {
    }



}