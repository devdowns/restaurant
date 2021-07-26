package com.devdowns.restaurant;

import com.devdowns.restaurant.consumers.Customer;
import com.devdowns.restaurant.enums.MenuItems;
import com.devdowns.restaurant.producers.Kitchen;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) {
        /*TODO 1 kitchen thread to produce dishes from an enum
          Multiple customers can eat dishes as they're made
          You can have customers clients that only eat certain dishes
         */


        var conveyorBelt = new ArrayBlockingQueue<MenuItems>(10);

        var kitchen = new Kitchen(conveyorBelt);
        var owen = new Customer("Owen", conveyorBelt);
        var dev = new Customer("Dev", conveyorBelt);

        var producerThread = new Thread(kitchen);
        var consumerThread = new Thread(owen);
        var consumerThread2 = new Thread(dev);

        producerThread.start();
        consumerThread.start();
        consumerThread2.start();



    }
}
