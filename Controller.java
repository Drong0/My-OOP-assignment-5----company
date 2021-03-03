package com.company;

import com.company.Interfaces.Interfaces;

import java.util.List;

public class Controller {
    private final Interfaces repo;

    public Controller(Interfaces repo){this.repo=repo;}
    public String addEmployee(String status, int salary, int experience){
        Workers workers = new Workers(status, salary, experience);
        boolean added = repo.addEmployee(workers);

        return (added ? "Employee has been added" : "Employee has not been added");//successfully or unsuccessfully added an employee
    }


    public String getAllEmployee(){
        List <Workers> workers = repo.getAllEmployee();

        return workers.toString();
    }

    public int totalCost() {
        int sum = repo.totalCost();
        return sum;
    }
}