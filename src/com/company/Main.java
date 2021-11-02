package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean(true);
        Storage storage = new Storage();

        Factory factory = new Factory(storage, flag);
        CountriesArmy greatBritain = new CountriesArmy("Great Britain", storage, flag);
        CountriesArmy france = new CountriesArmy("France", storage, flag);

        Thread factoryThread = new Thread(factory::makeDetail);
        Thread army1 = new Thread(greatBritain::run);
        Thread army2 = new Thread(france::run);

        factoryThread.start();
        army1.start();
        army2.start();

        army1.join();
        army2.join();
        factoryThread.join();

    }

}
