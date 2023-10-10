package com.ohgiraffers.section02.uses;

public class MemberRepository {

//    private final static Member[] members = new Member[10];
    private final static Member[] members;

    static {
        members = new Member[10];
    }

    private static int count;

    public static boolean store(Member[] newMembers){

        for (int i = 0; i < newMembers.length; i++){

            members[count++] = newMembers[i];
        }
        return true;
    }

    public static Member[] findAllMembers() {

        return members;
    }
}
