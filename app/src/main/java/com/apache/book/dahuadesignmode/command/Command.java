package com.apache.book.dahuadesignmode.command;

/**
 * Created by jerryliu on 2017/8/29.
 */

public abstract class Command {
    //烤肉串命令一来烤肉串者
    private IOperation barbecue;

    public Command(IOperation barbecue) {
        this.barbecue = barbecue;
    }

    public IOperation getBarbecue() {
        return barbecue;
    }

    public abstract void executeCommand();
}
