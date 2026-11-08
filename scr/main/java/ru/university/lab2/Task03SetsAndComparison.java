package ru.university.lab2;

import java.util.*;

public class Task03SetsAndComparison {

    public void run() {
        System.out.println("\n=== Задание № 3. Множества и сравнение объектов ===");

        // Создаем список объектов Human
        List<Human> list = new ArrayList<>();
        list.add(new Human("Иван", "Иванов", 25));
        list.add(new Human("Анна", "Петрова", 20));
        list.add(new Human("Борис", "Алексеев", 30));
        list.add(new Human("Иван", "Иванов", 25)); // дубликат для проверки множеств

        System.out.println("Исходный список со списком людей:");
        list.forEach(System.out::println);

        // 1. HashSet (порядок случаен, основан на hashCode, дубликаты удаляются)
        Set<Human> hashSet = new HashSet<>(list);
        System.out.println("\n1. HashSet (нет гарантированного порядка):");
        hashSet.forEach(System.out::println);

        // 2. LinkedHashSet (сохраняет порядок добавления элементов)
        Set<Human> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println("\n2. LinkedHashSet (порядок добавления сохраняется):");
        linkedHashSet.forEach(System.out::println);

        // 3. TreeSet (сортирует по естественному порядку Comparable)
        Set<Human> treeSetNatural = new TreeSet<>(list);
        System.out.println("\n3. TreeSet (естественный порядок через Comparable):");
        treeSetNatural.forEach(System.out::println);

        // 4. TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(list);
        System.out.println("\n4. TreeSet с компаратором по фамилии (HumanComparatorByLastName):");
        treeSetByLastName.forEach(System.out::println);

        // 5. TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(list);
        System.out.println("\n5. TreeSet с анонимным компаратором по возрасту:");
        treeSetByAge.forEach(System.out::println);

        /*
         * Объяснение различий в выводах коллекций:
         * - HashSet не гарантирует никакого порядка элементов, так как элементы упорядочиваются
         *   на основе их хэш-кодов (hashCode), обеспечивая при этом максимальную скорость поиска/вставки.
         * - LinkedHashSet сохраняет исходный порядок добавления элементов за счет поддержания двусвязного списка.
         * - TreeSet автоматически сортирует элементы. Если передать пустой конструктор (или коллекцию),
         *   используется естественный порядок из метода compareTo (в нашем случае по фамилии, имени и возрасту).
         *   При передаче кастомного Comparator (в п.4 и п.5) TreeSet использует его правилах сортировки вместо compareTo.
         */
    }
}