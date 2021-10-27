package com.company;

import java.util.LinkedList;
import java.util.List;

public class CountriesArmy implements Runnable {
    private Storage storage = new Storage();
    private Robot robot = new Robot();
    private Factory factory = new Factory();
    private List<String> army = new LinkedList<>();
    private boolean counter = true;

    public List<String> getArmy() {
        return army;
    }

    public boolean isCounter() {
        return counter;
    }

    @Override
    public void run() {
        String[] details = robot.returnRobotParts();
        int count = 0;

        if (count >= 20) {
            counter = false;
        }

        try {
            while (counter) {
                synchronized (storage.getDetails()) {
                    while (factory.makeDetail(details)) {
                        army.add(String.valueOf(factory.makeDetail(robot.returnRandomRobotParts())));
                        System.out.println("Details have been accepted!");
                        count++;
                    }
                }
            }
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

    }

}
