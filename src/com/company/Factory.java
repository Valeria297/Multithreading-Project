package com.company;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Factory {
    private Storage storage;
    private AtomicBoolean flag;

    Factory(Storage storage, AtomicBoolean flag) {
        this.storage = storage;
        this.flag = flag;
    }

    public void makeDetail() {
        try {
            while (flag.get()) {
                String[] robotDetails = Robot.returnRobotParts();
                for (int i = 0; i < robotDetails.length; i++) {
                    storage.addToDetailsList(robotDetails[i]);
                }
                System.out.println("Details was created...");
                Thread.sleep(2000);
            }
        } catch (InterruptedException ignored) {
        }
    }

}
