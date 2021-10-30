package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Storage {
    private final List<String> details = new ArrayList<>();

    public void addToDetailsList(String str) {
        details.add(str);
    }

    public String takeDetailFromList(String str) {
        String temp = " ";
        for (int i = 0; i < details.size(); i++) {
            if (str.equals(details.get(i))) {
                temp = details.remove(i);
            }
        }
              return temp;
    }

}
