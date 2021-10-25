package com.company;

import java.util.LinkedList;
import java.util.List;

public class CountriesArmy implements Runnable {

    private Robot robot = new Robot();
    private Factory factory = new Factory();
    private List<String> army = new LinkedList<>();

    public List<String> getArmy() {
        return army;
    }

    @Override
    public void run() {
        String[] details = robot.returnRobotParts();
        int count = 0;

        try {
            while (count < 20) {
                while (factory.makeDetail(details)) {
                    for (int i = 0, j = 3; j < details.length; i++, j++) {
                        String[] tempArr = new String[2];
                        tempArr[0] = details[i];
                        tempArr[1] = details[j];
                        army.add(String.valueOf(factory.makeDetail(tempArr)));
                        System.out.println("Details have been accepted!");
                    }
                    count++;
                }
            }
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

    }
}
