package com.education.ztu.game;

public class Schoolar extends Participant{
    public Schoolar(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Schoolar" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                '}';
    }
}
