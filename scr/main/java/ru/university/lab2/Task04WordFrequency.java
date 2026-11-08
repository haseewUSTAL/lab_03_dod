package ru.university.lab2;

import java.util.*;

/**
 * Задание № 4 — Частота слов с использованием HashMap
 */
public class Task04WordFrequency {

    public void run() {
        System.out.println("\n=== Задание № 4. Частота слов ===");

        String text = "Java is a high-level, class-based, object-oriented programming language. " +
                "Java is widely used for building enterprise applications, and java is awesome!";

        System.out.println("Исходный текст:\n" + text);

        // Приводим к нижнему регистру и разбиваем по не-буквенным символам (регулярное выражение)
        String[] words = text.toLowerCase().split("\\W+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("\nРазличные слова и частота их встречаемости:");
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("   Слово \"" + entry.getKey() + "\": " + entry.getValue() + " раз(а)");
        }
    }
}