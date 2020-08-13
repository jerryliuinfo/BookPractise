package com.apache.book.dahuadesignmode.command;

/**
 * Created by jerryliu on 2017/8/29.
 * 烤肉命令依赖烤肉串者
 */

public class CommandBakeMutton extends Command {


    public CommandBakeMutton(IOperation barbecue) {
        super(barbecue);
    }

    @Override
    public void executeCommand() {
        getBarbecue().bakeMutton();
    }
}
