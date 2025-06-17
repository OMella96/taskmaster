package com.equipo.taskmaster;

import java.util.ArrayList;

public class App {

    public static ArrayList<String> tasks = new ArrayList<>();

    public static void addTask(String task) {
        tasks.add(task);
    }

    public static void printTasks() {
        System.out.println("Tareas pendientes:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido a TaskMaster!");
        System.out.println("Ambiente: " + System.getProperty("env.name"));

        addTask("Estudiar Maven");
        addTask("Leer Sobre CI/CD");
        printTasks();
    }

}
