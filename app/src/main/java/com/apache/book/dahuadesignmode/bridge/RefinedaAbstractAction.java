package com.apache.book.dahuadesignmode.bridge;

/**
 * Created by Jerry on 2019/1/6.
 */
public class RefinedaAbstractAction extends AbstractAction {
    @Override
    public void opeation() {
        super.opeation();

        mImplementor.operation();
    }
}
