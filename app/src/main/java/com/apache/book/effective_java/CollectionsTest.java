package com.apache.book.effective_java;

import com.apache.book.effective_java.bean.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 01370340 on 2018/11/17.
 */
public class CollectionsTest {

    public static void main(String[] args) {
        testListDistinct();
    }

    public static void testListDistinct(){
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("a");

        Set<String> stringSet = new HashSet<>(stringList);
        System.out.println("before = "+stringList.toString() +"\nafter distinct" +stringSet.toString());


        System.out.println("\n");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("zhangsan", 10));
        personList.add(new Person("lisi", 11));
        personList.add(new Person("wangwu", 12));
        personList.add(new Person("lisi", 11));
        Set<Person> personSet = new HashSet<>(personList);

        System.out.println("before = "+personList.toString() +"\nafter distinct" +personSet.toString());


        List<Person> personList2 = new ArrayList<>();
        personList2.add(new Person("haha", 10));
        personList2.add(new Person("lisi", 11));

        Person[] array = new Person[]{new Person("haha", 10),new Person("lisi", 11)};
        Collections.addAll(personList2,array);
        System.out.println("personList2 = "+personList2);

    }
}
