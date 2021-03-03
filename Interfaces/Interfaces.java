package com.company.Interfaces;

import com.company.Workers;

import java.util.List;

public interface Interfaces {
    List<Workers> getAllEmployee();
    boolean addEmployee(Workers workers);
    int totalCost();
}