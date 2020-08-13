package com.apache.book.dahuadesignmode.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerryliu on 2017/8/29.
 */

public class Waiter {
    private List<Command> commandList = new ArrayList<>();

    public void addOrder(Command command){
        if (!commandList.contains(command)){
            if (command instanceof CommandChickeWing){
                System.out.println("服务员:鸡翅没有了，请点其他的烤肉");
            }else {
                commandList.add(command);
                System.out.println("增加烤羊肉订单");
            }
        }
    }

    public void cancelOrder(Command command){
        if (commandList.contains(command)){
            commandList.remove(command);
        }
    }


    public void notifyReceiver(){
        for (Command command : commandList) {
            command.executeCommand();
        }
    }

}
