package com.ttn.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;


@Controller
public class EmployeeController {
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employeeInfo() {
        return "Employee-Registration";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String employeeInfo2(Model model, String name, Integer age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "Question3";
    }

    @RequestMapping(value = "/employeetable", method = RequestMethod.GET)
    public String GetemployeeInfoTable() {
        return "Employee-Registration";
    }

    @RequestMapping(value = "/employeetable", method = RequestMethod.POST)
    public String PostemployeeInfoTable(Model model, String name, Integer age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "Question3";
    }




}
