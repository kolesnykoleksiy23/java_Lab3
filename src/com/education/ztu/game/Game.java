package com.education.ztu.game;

import java.util.Collection;
import java.util.Collections;

public class Game {
    public static void main(String[] args) throws CloneNotSupportedException {

        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        Student student1 = new Student("Mykola", 20);
        Student student2 = new Student("Viktoria", 21);
        Employee employee1 = new Employee("Andriy", 28);
        Employee employee2 = new Employee("Oksana", 25);
        Team<Schoolar> scollarTeam = new Team<>("Dragon");
        scollarTeam.addNewParticipant(schoolar1);
        scollarTeam.addNewParticipant(schoolar2);
        //scollarTeam.addNewParticipant(student1);  код не виконається
        //scollarTeam.addNewParticipant(employee1);

        Team<Student> studentTeam = new Team<>("Vpered");
        studentTeam.addNewParticipant(student2);
        studentTeam.addNewParticipant(student1);
        Team<Employee> employeeTeam = new Team<>("Robotyagi");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);
        Team anotherTeam = new Team("Fantaziya");
        //anotherTeam.addNewParticipant("hello"); // тут буде помилка

        Team<Schoolar> scollarTeam2 = new Team<>("Rozumnyky");
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olga", 14);
        scollarTeam2.addNewParticipant(schoolar3);
        scollarTeam2.addNewParticipant(schoolar4);
        scollarTeam.playWith(scollarTeam2);
        //scollarTeam.playWith(employeeTeam);

        System.out.println("\n ----- Завдання 3 клонування: -----\n");

        Participant s = (Participant) schoolar3.clone();
        System.out.println(s.getName());
        s.setName("sfjhdsfhhjfdsj");
        System.out.println(s.getName());
        System.out.println(schoolar3.getName());

// перевірка глибокого клонування + hashCode + equals
        Student studentEX1 = new Student("Alice", 20);
        Student studentEX2 = new Student("Bob", 22);

        Team<Student> teamA = new Team<>("Team A");
        teamA.addNewParticipant(studentEX1);
        teamA.addNewParticipant(studentEX2);

        Team<Student> clonedTeamA = (Team<Student>) teamA.clone();
        System.out.println("Original Team: " + teamA.getParticipants().toString());
        System.out.println("Cloned Team: " + clonedTeamA.getParticipants().toString());

        System.out.println("Cloned Team hashCode: " + clonedTeamA.getParticipants().hashCode());
        System.out.println("Original Team hashCode: " + teamA.getParticipants().hashCode());

        System.out.println("Does teams participants equals? " + teamA.getParticipants().equals(clonedTeamA.getParticipants()));
        System.out.println("Does firsts participants equals? " + teamA.getParticipants().getFirst().equals(clonedTeamA.getParticipants().getFirst()));


        System.out.println("____Change_____");

        // change original team
        Student changedS = teamA.getParticipants().getFirst();
        changedS.setName("Another Name");
        // перевіряємо склад команди
        System.out.println("Original Team: " + teamA.getParticipants().toString());
        System.out.println("Cloned Team: " + clonedTeamA.getParticipants().toString());
        // перевіряємо хеш коди
        System.out.println("Cloned Team hashCode: " + clonedTeamA.getParticipants().hashCode());
        System.out.println("Original Team hashCode: " + teamA.getParticipants().hashCode());
        // equals
        System.out.println("Does teams participants equals? " + teamA.getParticipants().equals(clonedTeamA.getParticipants()));
        System.out.println("Does firsts participants equals? " + teamA.getParticipants().getFirst().equals(clonedTeamA.getParticipants().getFirst()));


        // Task4
        Student student3 = new Student("Alexey", 39);
        studentTeam.addNewParticipant(student3);
        System.out.println("Task 4");
        System.out.println("Before sorting by name:");
        System.out.println(studentTeam.getParticipants());

        Collections.sort(studentTeam.getParticipants());
        System.out.println("After sorting by name:");
        System.out.println(studentTeam.getParticipants());

        System.out.println("After sorting by age:");
        Collections.sort(studentTeam.getParticipants(), new SortByAge());
        System.out.println(studentTeam.getParticipants());

        //для тестування сортування з декількомами параметрами:
        Student student4 = new Student("Alexey", 19);
        studentTeam.addNewParticipant(student4);
        System.out.println("Before multiple compared: " + studentTeam.getParticipants());
        Collections.sort(studentTeam.getParticipants(), new SortByName().thenComparing(new SortByAge()));
        System.out.println("After multiple compared: " + studentTeam.getParticipants());
    }
}
