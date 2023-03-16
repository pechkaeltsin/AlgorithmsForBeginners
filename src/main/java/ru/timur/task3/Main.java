package main.java.ru.timur.task3;

import java.util.Arrays;

/**
 * Занятие 3.
 *
 * @author fazylzyanov@reksoft.ru
 */
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 3, 9, 4, -5, 2, -1};
        int element = 3;
        System.out.println("Массив:\n" + Arrays.toString(arr));
        System.out.println("Исходный элемент: " + element);
        System.out.println("\nЗадание 1:\n" + binaryRecursion(arr, element, 0, arr.length - 1));
        System.out.println("\nЗадание 2:\n" + Arrays.toString(quickSort(arr, 0, arr.length - 1)));
    }

    /**
     * Задание 1. Реализовать Бинарный поиск через рекурсию
     */
    public static int binaryRecursion(int[] arr, int element, int firstId, int lastId) {

        if (firstId <= lastId) {
            int middleId = (firstId + lastId) / 2;
            if (arr[middleId] == element) {
                return middleId;
            }

            if (arr[middleId] < element) {
                firstId = middleId + 1;
            } else if (arr[middleId] > element) {
                lastId = middleId - 1;
            }
        }
        return binaryRecursion(arr, element, firstId, lastId);
    }

    /**
     * Задание 2. Реализовать алгоритм быстрой сортировки.
     */
    static int[] quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivot = arr[high];
            int i = (low-1);
            for (int j=low; j<high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = temp;
            int partition = i + 1;

            quickSort(arr, low, partition-1);
            quickSort(arr, partition+1, high);
        }
        return arr;
    }
}
