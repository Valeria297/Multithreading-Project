package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory();
        Thread mainThread = new Thread(factory);

        CountriesArmy greatBritain = new CountriesArmy();
        CountriesArmy france = new CountriesArmy();

        Thread t1 = new Thread(greatBritain);
        Thread t2 = new Thread(france);

        mainThread.start();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        if(!t1.isAlive()) {
            try{
                t1.join();
            } catch(InterruptedException e){}

            System.out.println("The Great Britain won!");
        } else {
            System.out.println("France won!");
        }

        System.out.println("The war is over!");
    }

}
