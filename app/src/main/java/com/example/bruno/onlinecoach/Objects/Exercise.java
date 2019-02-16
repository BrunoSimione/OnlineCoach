package com.example.bruno.onlinecoach.Objects;

import java.util.ArrayList;

public class Exercise {
    private String name;
    private ArrayList<Integer> history;

    public Exercise() {
        name = "Exercise ABC";
        history = new ArrayList<>();
    }

    public Exercise(String name) {
        this.name = name;
        history = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Integer> history) {
        this.history = history;
    }

    public static ArrayList<Exercise> createExerciseArrayList() {
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();

        Exercise e1 = new Exercise("Bench 12x3");
        Exercise e2 = new Exercise("Dumbbell 10x3");
        Exercise e3 = new Exercise("Running 2km");
        Exercise e4 = new Exercise("Leg press 12x4");

        exercises.add(e1);
        exercises.add(e2);
        exercises.add(e3);
        exercises.add(e4);
        exercises.add(e1);
        exercises.add(e2);
        exercises.add(e3);
        exercises.add(e4);

        return exercises;
    }

}
