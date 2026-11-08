package ru.university.lab2;

import java.util.Iterator;

/**
 * Задание № 2 — Генератор простых чисел с использованием Iterator
 */
public class PrimesGenerator implements Iterable<Integer> {
    private final int count;

    public PrimesGenerator(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be greater than 0");
        }
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimeIterator();
    }

    private class PrimeIterator implements Iterator<Integer> {
        private int generatedCount = 0;
        private int currentNumber = 1;

        @Override
        public boolean hasNext() {
            return generatedCount < count;
        }

        @Override
        public Integer next() {
            currentNumber = findNextPrime(currentNumber + 1);
            generatedCount++;
            return currentNumber;
        }

        private int findNextPrime(int start) {
            int candidate = start;
            while (!isPrime(candidate)) {
                candidate++;
            }
            return candidate;
        }

        private boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }
}