package com.apache.book.dahuadesignmode.builder;

/**
 * Created by jerryliu on 2017/7/16.
 */

public class PersonDirector {

    private PersonBuilder personBuilder;

    public PersonDirector(PersonBuilder builder){
        this.personBuilder = builder;
    }

    public void createPerson(){
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildLeftArm();
        personBuilder.buildRightArm();
        personBuilder.buildLeftLeg();
        personBuilder.buildRightLeg();
    }
}
