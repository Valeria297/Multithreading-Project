package com.company;

import java.util.LinkedList;

public class Robot {

    private static Robot head;
    private static Robot body;
    private static Robot rightHand;
    private static Robot leftHand;
    private static Robot rightLeg;
    private static Robot leftLeg;

    Robot() {
    }

    Robot(Robot head, Robot body, Robot rightHand, Robot leftHand, Robot rightLeg, Robot leftLeg) {
        this.head = head;
        this.body = body;
        this.rightHand = rightHand;
        this.leftHand = leftHand;
        this.rightLeg = rightLeg;
        this.leftLeg = leftLeg;
    }

    public static Robot getHead() {
        return head;
    }

    public static Robot getBody() {
        return body;
    }

    public static Robot getRightHand() {
        return rightHand;
    }

    public static Robot getLeftHand() {
        return leftHand;
    }

    public static Robot getLeftLeg() {
        return leftLeg;
    }

    public static Robot getRightLeg() {
        return rightLeg;
    }

    public static boolean equals(Object obj, LinkedList<Robot> list) {
        if (!(obj instanceof Robot)){
            return false;
        }

        int value = 0;
        Robot tempRobot = (Robot) obj;

        while (value <= 20) {
            for (int i = 0; i < list.size(); i++) {
                if (obj.equals(Robot.getBody()) && obj.equals(Robot.getHead())
                && obj.equals(Robot.getLeftHand()) && obj.equals(Robot.getRightHand())
                && obj.equals(Robot.getLeftLeg()) && obj.equals(Robot.getRightLeg())) {
                    value++;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "head=" + head +
                ", body=" + body +
                ", rightHand=" + rightHand +
                ", leftHand=" + leftHand +
                ", rightLeg=" + rightLeg +
                ", leftLeg=" + leftLeg +
                '}';
    }

}
