package com.apache.book.dahuadesignmode.decoate;

/**
 * Created by jerryliu on 2017/7/16.
 */

public abstract class Decorator extends Component {

    protected Component component;

    public void setComponent(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null){
            component.operation();
        }
    }
}
