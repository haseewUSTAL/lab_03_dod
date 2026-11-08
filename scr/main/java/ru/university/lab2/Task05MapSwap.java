package ru.university.lab2;

import java.util.HashMap;
import java.util.Map;

/**
 * Задание № 5 — Обмен ключей и значений в Map
 */
public class Task05MapSwap {

    /**
     * Метод меняет местами ключи и значения в Map.
     * Если значения повторялись, последнее перезапишет предыдущие.
     */
    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> originalMap) {
        Map<V, K> swappedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }
        return swappedMap;
    }

    public void run() {
        System.out.println("\n=== Задание № 5. Обмен ключей и значений в Map ===");

        Map<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "One");
        originalMap.put(2, "Two");
        originalMap.put(3, "Three");

        System.out.println("Исходная Map: " + originalMap);

        Map<String, Integer> swappedMap = swapKeysAndValues(originalMap);

        System.out.println("Map после обмена ключей и значений: " + swappedMap);
    }
}