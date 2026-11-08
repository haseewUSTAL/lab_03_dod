package ru.university.lab2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Запуск лабораторной работы №2 (для студента: лаб. №3)...\n");

        // Задание 1
        Task01Collections task1 = new Task01Collections();
        task1.run();

        // Задание 2
        PrimesGeneratorTest task2 = new PrimesGeneratorTest();
        task2.run();

        // Задание 3
        Task03SetsAndComparison task3 = new Task03SetsAndComparison();
        task3.run();

        // Задание 4
        Task04WordFrequency task4 = new Task04WordFrequency();
        task4.run();

        // Задание 5
        Task05MapSwap task5 = new Task05MapSwap();
        task5.run();

        System.out.println("\nВсе задания успешно выполнены!");
    }
}