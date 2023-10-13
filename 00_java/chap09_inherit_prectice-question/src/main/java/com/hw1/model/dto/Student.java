package com.hw1.model.dto;

public class Student extends Person{
    private int grade; //학년
    private String major; //전공

    public Student() {
    }

    public Student(int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        this.grade = grade;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", major='" + major + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
