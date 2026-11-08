package ru.university.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Проверочный класс для генератора простых чисел
 */
public class PrimesGeneratorTest {

    public void run() {
        System.out.println("\n=== Задание № 2. Генератор простых чисел ===");
        int n = 10; // Первые 10 простых чисел
        PrimesGenerator generator = new PrimesGenerator(n);

        // Перебор через Iterator в прямом порядке
        List<Integer> primesList = new ArrayList<>();
        Iterator<Integer> iterator = generator.iterator();
        while (iterator.hasNext()) {
            primesList.add(iterator.next());
        }

        System.out.println("Прямой порядок первых " + n + " простых чисел: " + primesList);

        // Вывод в обратном порядке
        List<Integer> reversedList = new ArrayList<>(primesList);
        Collections.reverse(reversedList);
        System.out.println("Обратный порядок простых чисел: " + reversedList);
    }
}