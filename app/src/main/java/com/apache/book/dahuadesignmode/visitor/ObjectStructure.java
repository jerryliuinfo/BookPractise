package com.apache.book.dahuadesignmode.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2019/1/6.
 */
public class ObjectStructure {

    private List<Person> elements = new ArrayList<>();

    public void attach(Person person){
        elements.add(person);
    }

    public void detach(Person person){
        int index = elements.indexOf(person);
        if (index >= 0){
            elements.remove(index);
        }
    }

    public void display(Action vistor){
        for (Person element : elements) {
            element.accept(vistor);
        }
    }
}
