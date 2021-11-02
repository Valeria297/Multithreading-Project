package com.company;

import java.util.LinkedList;
import java.util.Random;

public class Robot {

    private static final String[] robotParts = {"Head", "Body", "Right hand", "Left hand", "Right leg", "Left leg"};

    public static String[] returnRobotParts() {
        return robotParts;
    }

    public static String[] returnRandomRobotParts() {
        String[] tempArr = new String[2];
        tempArr[0] = robotParts[(int) (Math.random() * 5)];
        tempArr[1] = robotParts[(int) (Math.random() * 5)];
        return tempArr;
    }

}
