package com.company;


public class Workers {
    //all class fields
    private int id;
    private String status;
    private int salary;
    private int experience;

    //getters and setters for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    //constructors
    public Workers(int id, String status, int salary, int experience) {
        this.id = id;
        this.status = status;
        this.salary = salary;
        this.experience = experience;
    }

    public Workers(String status, int salary, int experience) {
        this.status = status;
        this.salary = salary;
        this.experience = experience;
    }
    //toString method for output
    public String toString() {
        return id + " | " + status + " | " + salary + " | " + experience  + "\n";
    }
}
