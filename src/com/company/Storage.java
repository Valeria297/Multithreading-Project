package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Storage {
    private final List<String> details = new ArrayList<>();

    public void addToDetailsList(String str) {
        synchronized (details) {
            details.add(str);
        }
    }

    public String takeDetailFromList(String str) {
        synchronized (details) {
            for (int i = 0; i < details.size(); i++) {
                if (str.equals(details.get(i))) {
                    return details.remove(i);
                }
            }
            return null;
        }
    }

}
