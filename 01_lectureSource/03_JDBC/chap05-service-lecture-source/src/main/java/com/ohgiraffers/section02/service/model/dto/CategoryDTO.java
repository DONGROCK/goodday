package com.ohgiraffers.section02.service.model.dto;

public class CategoryDTO implements java.io.Serializable{

private int code;
private String name;
private Integer reCategoryCode; //널값을 포함에서 쓰려면 int노노 Integer



    public CategoryDTO() {
    }

    public CategoryDTO(int code, String name, Integer reCategoryCode) {
        this.code = code;
        this.name = name;
        this.reCategoryCode = reCategoryCode;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", reCategoryCode=" + reCategoryCode +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReCategoryCode() {
        return reCategoryCode;
    }

    public void setReCategoryCode(Integer reCategoryCode) {
        this.reCategoryCode = reCategoryCode;
    }
}

