package com.company;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Factory {

    private Robot robot = new Robot();
    protected static final List<Robot> ROBOT_DETAILS = new LinkedList<>();

    protected static boolean makeDetail() {
        List<Robot> ROBOT_PARTS = new LinkedList<>();
        ROBOT_PARTS.add(Robot.getHead());
        ROBOT_PARTS.add(Robot.getBody());
        ROBOT_PARTS.add(Robot.getLeftHand());
        ROBOT_PARTS.add(Robot.getRightHand());
        ROBOT_PARTS.add(Robot.getLeftLeg());
        ROBOT_PARTS.add(Robot.getRightLeg());

        try {
            int value = 0;
            while (ROBOT_DETAILS.isEmpty()) {
                synchronized (ROBOT_DETAILS) {
                    while (ROBOT_DETAILS.size() == 20) {
                        ROBOT_DETAILS.wait(2000);
                    }
                    Thread.sleep(5000);
                    Object ob = random(ROBOT_PARTS);
                    ROBOT_DETAILS.add((Robot) ob);
                    System.out.println("Detail-maker create: " + ++value);
                }
            }
        } catch (InterruptedException ignored) {
        }
        return false;
    }

    public static <T> T random(Collection<T> list) {
        int num = (int) (Math.random() * list.size());
        for (T t : list) {
            if (--num < 0) {
                return t;
            }
        }
        throw new AssertionError();
    }

    protected static List<Robot> returnDetails() {
        List<Robot> list = new LinkedList<>();

        while(!ROBOT_DETAILS.isEmpty()) {
            for (int i = 0; i < ROBOT_DETAILS.size(); i++) {
                Robot ob = ROBOT_DETAILS.get(i);
                list.add(ob);
            }
            return list;
        }
        return null;
    }

}
