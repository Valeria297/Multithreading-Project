package com.company;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Factory extends Thread {
    private Storage storage = new Storage();
    private Robot robot = new Robot();
    private CountriesArmy cA = new CountriesArmy();

    protected boolean makeDetail(String[] details) {
        String[] robotDetails = robot.returnRobotParts();

        try {
            while (cA.isCounter()) {
                synchronized (storage.getDetails()) {
                    for (int i = 0; i < details.length; i++) {
                        storage.addToDetailsList(returnDetails(robotDetails, details[i]));
                    }
                    System.out.println("Details was created...");
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException ignored) {}
        return false;
    }

    protected String returnDetails(String[] robParts, String str) {
        String string = " ";
        for (int i = 0; i < robParts.length; i++) {
            if (robParts[i].equals(str)) {
                string = str;
            } else {
                return null;
            }
        }
        return str;
    }

}
