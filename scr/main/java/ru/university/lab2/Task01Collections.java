package ru.university.lab2;

import java.util.*;

/**
 * Задание № 1 — Методы Collections
 */
public class Task01Collections {

    public void run() {
        System.out.println("=== Задание № 1. Методы Collections ===");

        // 1. Создание массива из N случайных чисел от 0 до 100
        int n = 15;
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("1. Исходный массив: " + Arrays.toString(array));

        // 2. Создание списка List на основе массива
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("2. Список List: " + list);

        // 3. Отсортируйте список по возрастанию
        Collections.sort(list);
        System.out.println("3. Отсортирован по возрастанию: " + list);

        // 4. Отсортируйте список в обратном порядке
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("4. Отсортирован в обратном порядке: " + list);

        // 5. Перемешайте список
        Collections.shuffle(list);
        System.out.println("5. Перемешанный список (shuffle): " + list);

        // 6. Выполните циклический сдвиг на 1 элемент
        Collections.rotate(list, 1);
        System.out.println("6. Циклический сдвиг на 1: " + list);

        // 7. Оставьте в списке только уникальные элементы
        List<Integer> uniqueList = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("7. Только уникальные элементы: " + uniqueList);

        // 8. Оставьте в списке только дублирующиеся элементы
        List<Integer> duplicatesList = findDuplicates(list);
        System.out.println("8. Только дублирующиеся элементы: " + duplicatesList);

        // 9. Из списка получите массив
        Integer[] resultArray = list.toArray(new Integer[0]);
        System.out.println("9. Преобразован обратно в массив: " + Arrays.toString(resultArray));

        // 10. Подсчитайте количество вхождений каждого числа и выведите результат
        System.out.println("10. Подсчет вхождений:");
        printFrequency(list);
    }

    private List<Integer> findDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (Integer num : list) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return new ArrayList<>(duplicates);
    }

    private void printFrequency(List<Integer> list) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer num : list) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println("   Число " + entry.getKey() + " встретилось " + entry.getValue() + " раз(а).");
        }
    }
}