package com.ohgiraffers.section04.use2;

public class Person {

    private SaveProvider saveProvider;

    public Person(SaveProvider saveProvider){
        this.saveProvider = saveProvider;
    }

    public void doSometing(){
        String data = "string data";
        saveProvider.save(data);
    }
}
