package com.education.ztu.game;

import java.util.Comparator;

public class SortByName implements Comparator<Participant> {

    @Override
    public int compare(Participant p1, Participant p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
