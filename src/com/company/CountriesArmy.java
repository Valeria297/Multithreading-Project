package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountriesArmy implements Runnable {
    private Storage storage = new Storage();
    private Robot robot = new Robot();
    private Factory factory = new Factory();
    private ArrayList<String> army = new ArrayList<>(6);
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
                        if (!storage.takeDetailFromList("Head").equals(false)) {
                            army.add((String) storage.takeDetailFromList("Head"));
                        } else if (!storage.takeDetailFromList("Body").equals(false)) {
                            army.add((String) storage.takeDetailFromList("Body"));
                        } else if (!storage.takeDetailFromList("Right hand").equals(false)) {
                            army.add((String) storage.takeDetailFromList("Right hand"));
                        } else if (!storage.takeDetailFromList("Left hand").equals(false)) {
                            army.add((String) storage.takeDetailFromList("Left hand"));
                        } else if (!storage.takeDetailFromList("Right leg").equals(false)) {
                            army.add((String) storage.takeDetailFromList("Right leg"));
                        } else if (!storage.takeDetailFromList("Left leg").equals(false)) {
                            army.add((String) storage.takeDetailFromList("Left leg"));
                        }
                        System.out.println("Details have been accepted!");

                       if (army.contains("Head") && army.contains("Body")
                       && army.contains("Right hand") && army.contains("Left hand")
                       && army.contains("Right leg") && army.contains("Left leg")) {
                           count++;
                           army.clear();
                       }
                    }
                }
            }
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

    }

}
