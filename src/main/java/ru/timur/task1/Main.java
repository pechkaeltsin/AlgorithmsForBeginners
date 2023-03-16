package main.java.ru.timur.task1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Занятие 1.
 *
 * @author fazylzyanov@reksoft.ru
 */
public class Main {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {2,4,6,8};

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int element = in.nextInt();

        System.out.println("\nПервый массив: " + Arrays.toString(arr1) + "\nВторой массив: " + Arrays.toString(arr2));
        System.out.println("Искомый элемент: " + element);
        System.out.println("\nЗадание 1:\nЛинейный поиск. Номер элемента: " + linearSearch(arr1, element));
        if (binarySearch(arr1, element) == -1) {
            System.out.println("\nЗадание 2:\nБинарный поиск. Элемент отсутствует!");
        } else {
            System.out.println("\nЗадание 2:\nБинарный поиск. Номер элемента: " + binarySearch(arr1, element));
        }
        System.out.println("\nЗадание 3:\nОтличные элементы массивов: ");
        compareLists(arr1, arr2);
    }

    /**
     * Задание 1.
     * Задача: реализовать алгоритм линейного поиска для массива.
     */
    public static int linearSearch(int[] arr, int element) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Задание 2.
     * Задача: реализовать алгоритм бинарного поиска для массива.
     */
    public static int binarySearch(int[] arr, int element) {

        int firstId = 0;
        int lastId = arr.length - 1;

        while (firstId <= lastId) {
            int middleId = (firstId + lastId) / 2;
            if (arr[middleId] == element) {
                return middleId;
            } else if (arr[middleId] < element) {
                firstId = middleId + 1;
            } else if (arr[middleId] > element) {
                lastId = middleId - 1;
            }
        }
        return -1;
    }

    /**
     * Задание 3.
     * Условие: есть 2 сортированных последовательности целых чисел. Необходимо напечатать те элементы из первой последовательности, которых нет во второй последовательности.
     */
    public static void compareLists(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                j++;
            } else {
                System.out.println(arr1[i]);
            }
            i++;
        }
    }
}