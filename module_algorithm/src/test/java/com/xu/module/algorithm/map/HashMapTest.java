package com.xu.module.algorithm.map;

import com.xu.module.algorithm.PrintUtil;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @org.junit.Test
    public void test() {
        Map<Person, Integer> map = new HashMap<>();
        Person person1 = new Person("xu");
        Person person2 = new Person("xu");
        PrintUtil.print(person1.hashCode());
        PrintUtil.print(person2.hashCode());
//        map.put(person1, 23);
//        map.put(person2, 25);

    }
}
