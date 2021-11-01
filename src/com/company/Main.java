package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean(true);

        Factory factory = new Factory(new Storage(), flag);
        CountriesArmy greatBritain = new CountriesArmy(new Storage());
        CountriesArmy france = new CountriesArmy(new Storage());

        Thread factoryThread = new Thread(factory);
        Thread army1 = new Thread(greatBritain);
        Thread army2 = new Thread(france);

        try {
            while (flag.equals(true)) {
                factoryThread.start();
                army1.start();
                army2.start();

                factoryThread.join();
                army1.join();
                army2.join();

               if (!greatBritain.isCounter() || !france.isCounter()){
                   flag.set(false);
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!army1.isAlive()) {
            try {
                army1.join();
            } catch (InterruptedException e) {
            }

            System.out.println("The Great Britain won!");
        } else {
            System.out.println("France won!");
        }

        System.out.println("The war is over!");
    }

}
