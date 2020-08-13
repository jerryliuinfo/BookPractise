package com.apache.book.dahuadesignmode.decoate;

/**
 * Created by jerryliu on 2017/7/16.
 */

public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
