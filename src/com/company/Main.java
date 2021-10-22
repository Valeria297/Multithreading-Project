package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread factory = new Thread(Factory::makeDetail);
        Thread greatBritain = new Thread(GreatBritainArmy::takeDetail);
        Thread france = new Thread(FranceArmy::takeDetail);
        factory.start();
        greatBritain.start();
        france.start();
        factory.join();
        greatBritain.join();
        france.join();

        if(greatBritain.isAlive()) {
            try{
                greatBritain.join();
            } catch(InterruptedException e){}

            System.out.println("The Great Britain won!");
        } else {
            System.out.println("France won!");
        }

        System.out.println("The war is over!");
    }
}
