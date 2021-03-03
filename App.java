package com.company;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    private final Controller controller;
    private final Scanner scanner;

    public App(Controller controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("Select option: (0-3)");
            System.out.println("1. Get all employee");
            System.out.println("2. Add employee");
            System.out.println("3. Total cost of company");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (0-3)");
                int option = scanner.nextInt();
                if(option==1){
                    getAllEmployeeMenu();
                }
                else if(option ==2){
                    AddEmployeeMenu();
                }
                else if(option == 3){
                    totalCostMenu();
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("*******************************");
        }
    }


    public void getAllEmployeeMenu(){
        String response = controller.getAllEmployee();
        System.out.println(response);
    }

    public void AddEmployeeMenu(){
        System.out.println("Please enter status:");
        String status = scanner.next();
        System.out.println("Please enter salary:");
        int salary = scanner.nextInt();
        int experience = 0;
        String response = controller.addEmployee(status,salary,experience);
        System.out.println(response);
    }
    public void totalCostMenu(){
        int response = controller.totalCost();
        System.out.println("Total cost of the company "+response+" tg");
    }
}