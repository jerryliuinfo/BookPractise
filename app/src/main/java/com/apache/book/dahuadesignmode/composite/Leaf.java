package com.apache.book.dahuadesignmode.composite;

/**
 * Created by jerryliu on 2017/8/23.
 */

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("cannot add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("cannot remove from a leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println(CompositeUtil.getLine(depth) + name);
    }


}
