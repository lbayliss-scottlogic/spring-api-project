package com.scottlogic.grad_training.friendface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/greetings")
@RestController
public class GreetingController {

    private final EmployeeOfTheMonthService employeeOfTheMonthService;

    @GetMapping("/employee")
    public Employee employeeOfTheMonth() {
        return employeeOfTheMonthService.computeEmployeeOfTheMonth();
    }

    public GreetingController(EmployeeOfTheMonthService employeeOfTheMonthService) {
        this.employeeOfTheMonthService = employeeOfTheMonthService;
    }
}