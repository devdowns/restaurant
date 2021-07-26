package com.devdowns.restaurant.consumers;

import com.devdowns.restaurant.enums.MenuItems;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
    BlockingQueue conveyorBelt = null;
    private String name;

    public Customer(String name, BlockingQueue<MenuItems> conveyorBelt){
        this.name = name;
        this.conveyorBelt = conveyorBelt;
    }

    @Override
    public void run() {
        while (true) {
            try {
                var dish = this.conveyorBelt.take().toString();
                System.out.println(this.name + " ate " + dish);
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(this.name + " got interrupted");
            }
        }
    }
}
