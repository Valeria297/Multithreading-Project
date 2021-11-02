package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CountriesArmy {
    private String name;
    private Storage storage;
    private ArrayList<String> details = new ArrayList<>();
    private int counter = 0;
    private AtomicBoolean flag;

    CountriesArmy(String name, Storage storage, AtomicBoolean flag) {
        this.name = name;
        this.storage = storage;
        this.flag = flag;
        details.addAll(Arrays.asList(Robot.returnRobotParts()));
    }

    public void run() {
        while (flag.get()) {
            String detail = details.get(0);
            String detailFromStorage = storage.takeDetailFromList(detail);

            if (detailFromStorage == null) {
                continue;
            }
            details.remove(0);

            if (details.isEmpty()) {
                counter++;
                if (counter == 20) {
                    flag.set(false);
                    System.out.println(name + " won!");
                    return;
                }
                details.addAll(Arrays.asList(Robot.returnRobotParts()));
            }
        }
    }

}
