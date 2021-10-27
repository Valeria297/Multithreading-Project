package com.company;

import java.util.LinkedList;

public class Storage {
    private LinkedList<String> details = new LinkedList<>();

    protected void addToDetailsList(String str) {
        details.add(str);
    }

    protected void deleteFromDetailsList(String str) {
        String temp = " ";
        for (int i = 0; i < details.size(); i++) {
            if (str.equals(details.get(i))) {
                temp = str;
            }
        }
        details.remove(temp);
    }

    protected String takeDetailFromList(String str) {
        String temp = " ";
        for (int i = 0; i < details.size(); i++) {
            if (str.equals(details.get(i))) {
                temp = details.get(i);
            }
        }
        return temp;
    }

    public LinkedList<String> getDetails() {
        return details;
    }

}
