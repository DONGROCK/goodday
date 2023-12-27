package com.ohgiraffers.section03.map.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /*
        * Map 인터페이스의 특징
        * Collection 인터페이스와는 다른 저장 방식을 가진다.
        * 키(key)와 값(value)를 하나의 쌍으로 저장하는 방식을 사용한다.
        *
        * 키(key)란?
        * 값(Value)를 찾기 위한 이름 역할을 하는 객체를 의미한다.
        * 1. 요소의 저장 순서를 유지하지 않는다.
        * 2. 키는 중복을 허용하지 않지만, 키가 다르면 중복되는 값은 저장 가능하다.
        *
        * HashMap, HashTable, TreeMap 등의 대표적인 클래스가 있다.
        * HashMap이 가장 많이 사용되면 HashTable은 JDK1.0 부터 제공되며
        * HashMap과 동일하게 동작한다. 하위 호환을 위해 남겨놓았기 때문에 가급적이면 HashMap을 사용하는 것이 좋다.
        *
        * Map<String, String> => 문자열, 문자열
        * Map<Integer, String> => 정수형, 문자열
        * Map<String, Object> => 여러가지 타입을 넣을 떄 만능키Object
        *
        * HashMap
        * JDK 1.2 부터 제공되는 클래스로 해시알고리즘을 사용하여 검색 속도가 매우 빠르다.
        *
        * */

        HashMap hmap = new HashMap<>();

        Map hmap2 = new HashMap();

        /*
        * Map객체에 요소를 추가할 때는 put()메소드를 이용한다.
        * 키와 값 둘다 반드시 객체여야한다.
        * 키와 값 쌍으로 저장한다.
        * */
        hmap.put("one", new Date());
        hmap.put(12, "red Apple"); //오토박싱
        hmap.put(33, 123);

        System.out.println("hmap = " + hmap);
        /*키는 중복 저장되지 않는다(set) : 최근 키로 override 된다.*/
        hmap.put(12, "yellow banana");
        System.out.println("hmap = " + hmap);

        /*값 객체 저장은 중복 저장된다.*/
        hmap.put(11, "yellow banana");
        hmap.put(9, "yellow banana");
        System.out.println("hmap = " + hmap);

        System.out.println("키 9에 대한 객체 : " + hmap.get(9));
        hmap.remove(9);
        System.out.println(hmap);
        System.out.println(hmap.size());

        HashMap<String, String> hmap3 = new HashMap<>();
        hmap3.put("one", "java 11");
        hmap3.put("two", "oracle 18c");
        hmap3.put("three", "jdbc");
        hmap3.put("four", "html5");
        hmap3.put("five", "css3");

        /*1. keySet()을 이용해서 키만 따로 set으로 만들고, iterator()로 키에 대한 목록 만듦*/
//        Set<String> keys = hmap3.keySet();
//        Iterator<String> keyIter = keys.iterator();
        Iterator<String> keyIter = hmap3.keySet().iterator();

            while (keyIter.hasNext()){
                String key = (String)keyIter.next(); // 첫번째키, 두번째키 ....
                String value = (String)hmap3.get(key);
                System.out.println(key + " = " + value);//키와 벨류
            }

            /*2. 저장된 value객체들만 values()로 가져오자*/
        Collection<String> values = hmap3.values();

        Iterator<String> valueIter = values.iterator();
        while (valueIter.hasNext()){
            System.out.println(valueIter.next());
        }

        Object[] valueArr = values.toArray();
        for (int i = 0; i < valueArr.length ; i++){
            System.out.println(i + " : " + valueArr[i]);
        }

            /*3. Map의 내부클래스인 EntrySet을 이용*/
        Set<Map.Entry<String, String>> set = hmap3.entrySet();
        Iterator<Map.Entry<String, String>> entryIter = set.iterator();

        while (entryIter.hasNext()){
            Map.Entry<String, String> entry = entryIter.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}
