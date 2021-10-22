package com.company;

import java.util.LinkedList;
import java.util.List;

import static com.company.Factory.ROBOT_DETAILS;

public class FranceArmy extends Thread {

    private Robot robot = new Robot();
    private static Factory factory = new Factory();
    private static List<Robot> armyFrance = new LinkedList<>();
    private static volatile boolean armyGathering = true;

    public static void takeDetail() {
        try {
            while (armyGathering) {
                while(factory.returnDetails() != null) {
                    for (int i = 0; i < ROBOT_DETAILS.size(); i++) {
                        Robot ob = ROBOT_DETAILS.get(i);
                        armyFrance.add(ob);

                        if (!Robot.equals(armyFrance.get(i),
                                (LinkedList<Robot>) armyFrance)) {
                            armyGathering = false;
                        }
                    }
                }
            }

            Thread.sleep(5000);
        } catch (InterruptedException ignored) { }
    }
}
