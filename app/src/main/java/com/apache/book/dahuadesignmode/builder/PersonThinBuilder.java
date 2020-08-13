package com.apache.book.dahuadesignmode.builder;

/**
 * Created by jerryliu on 2017/7/16.
 */

public class PersonThinBuilder extends PersonBuilder {
    @Override
    public void buildHead() {
        System.out.println("build thin head");
    }

    @Override
    public void buildBody() {
        System.out.println("build thin body");

    }

    @Override
    public void buildLeftArm() {
        System.out.println("build thin left arm");

    }

    @Override
    public void buildRightArm() {
        System.out.println("build thin right arm");

    }

    @Override
    public void buildLeftLeg() {
        System.out.println("build thin left leg");

    }

    @Override
    public void buildRightLeg() {
        System.out.println("build thin right leg");

    }
}
