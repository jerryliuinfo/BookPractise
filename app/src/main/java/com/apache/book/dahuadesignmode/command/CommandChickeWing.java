package com.apache.book.dahuadesignmode.command;

/**
 * Created by jerryliu on 2017/8/29.
 */

public class CommandChickeWing extends Command {


    public CommandChickeWing(IOperation barbecue) {
        super(barbecue);
    }

    @Override
    public void executeCommand() {
        getBarbecue().bakeChickenWing();
    }
}
