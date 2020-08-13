package com.apache.book.dahuadesignmode.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerryliu on 2017/8/23.
 */

public class Composite extends Component {
    private List<Component> list = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }


    @Override
    public void add(Component c) {
        list.add(c);
    }

    @Override
    public void remove(Component c) {
        list.remove(c);
    }

    @Override
    public void display(int depth) {
        System.out.println(CompositeUtil.getLine(depth) + name);
        for (Component component : list) {
            component.display(depth + 2);
        }
    }
}
