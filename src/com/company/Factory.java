package com.company;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Factory extends Thread {
    private Storage storage;
    private Robot robot = new Robot();

    Factory() {}

    Factory (Storage storage) {
        this.storage = storage;
    }

    protected void makeDetail(String[] details) {
        String[] robotDetails = robot.returnRobotParts();

        try {
            while (true) {
                for (int i = 0; i < details.length; i++) {
                    storage.addToDetailsList(details[i]);
                }
                System.out.println("Details was created...");
                Thread.sleep(2000);
            }
        } catch (InterruptedException ignored) {
        }
    }

}
