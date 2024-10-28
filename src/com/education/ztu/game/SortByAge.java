package com.education.ztu.game;

import java.util.Comparator;

public class SortByAge implements Comparator<Participant> {

    @Override
    public int compare(Participant p1, Participant p2) {
        if (p1.getAge() > p2.getAge()) {
            return 1;
        }
        if (p1.getAge() < p2.getAge()) {
            return -1;
        }
        return 0;
    }
}
