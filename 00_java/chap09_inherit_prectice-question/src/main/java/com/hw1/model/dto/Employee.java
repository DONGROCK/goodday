package com.hw1.model.dto;

public class Employee extends Person{
private int salary; //급여
private String dept; //부서

    public Employee() {
    }

    public Employee(int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        this.salary = salary;
        this.dept = dept;
    }
}
