package com.ohgiraffers.section01.generic;

public class GenericTest<T> {
                    //<타입변수>
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
