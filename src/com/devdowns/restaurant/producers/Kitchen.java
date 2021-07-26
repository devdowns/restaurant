package com.devdowns.restaurant.producers;

import com.devdowns.restaurant.enums.MenuItems;

import java.util.concurrent.BlockingQueue;

public class Kitchen implements Runnable{
    BlockingQueue conveyorBelt = null;

    public Kitchen(BlockingQueue<MenuItems> conveyorBelt){this.conveyorBelt = conveyorBelt;}

    @Override
    public void run() {
        while(true){
            try{
                var dish = MenuItems.getRandomItem();
                this.conveyorBelt.put(dish);
                System.out.println("ding ding, "+dish.toString()+" is ready!");
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
    }
}
