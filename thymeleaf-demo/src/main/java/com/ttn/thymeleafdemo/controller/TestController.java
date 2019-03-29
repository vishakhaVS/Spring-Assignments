package com.ttn.thymeleafdemo.controller;

import com.ttn.thymeleafdemo.entity.Employee;
import com.ttn.thymeleafdemo.entity.Question5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


@Controller
public class TestController {


    @RequestMapping(value = "/question1", method = RequestMethod.GET)

    public String testHi() {

        return "Question1";
    }

    @RequestMapping(value = "/question2", method = RequestMethod.GET)

    public String testQuestion2() {

        return "Question2";
    }

    @GetMapping("/question5")
    public String getAdmin(Model model) {
        model.addAttribute("user", Arrays.asList(new Question5("Vishakha",
                "Delhi", false), new Question5("Siddharth",
                "Mumbai", true)));
        return "Question5";
    }

    @GetMapping("/question7")
    public String getPage() {
        return "Question7";
    }

    @GetMapping("/getTime")
    @ResponseBody
    public String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    @GetMapping("/question8")
    public String getEmp(Model model) {
        model.addAttribute("user", Arrays.asList(new Question5("Yatin", "delhi", true)
                , new Question5("Siddharth", "Mumbai", false)));
        return "Question8";
    }


    @GetMapping("/question9")
    public String getEnum() {
        return "Question9";
    }


    @GetMapping("/question10")
    public String getLoaderForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "Question10";
    }
}

