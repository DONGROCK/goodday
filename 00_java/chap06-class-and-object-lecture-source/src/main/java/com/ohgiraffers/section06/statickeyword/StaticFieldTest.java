package com.ohgiraffers.section06.statickeyword;

public class StaticFieldTest {

    private int nonStaticCount;
    private static int staticCount;

    public StaticFieldTest(){
    }

    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public int getStaticCount() {
        return staticCount;
    }

    public void increaseNonStaticCount(){
        this.nonStaticCount++;
    }

    public void increaseStaticCount(){
        StaticFieldTest.staticCount++;
    }
}
