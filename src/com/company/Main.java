package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory();
        CountriesArmy greatBritain = new CountriesArmy();
        CountriesArmy france = new CountriesArmy();

        Thread factoryThread = new Thread(factory);
        Thread army1 = new Thread(greatBritain);
        Thread army2 = new Thread(france);

        factoryThread.start();
        army1.start();
        army2.start();

        factoryThread.join();
        army1.join();
        army2.join();

        if(!army1.isAlive()) {
            try{
                army1.join();
            } catch(InterruptedException e){}

            System.out.println("The Great Britain won!");
        } else {
            System.out.println("France won!");
        }

        System.out.println("The war is over!");
    }

}
