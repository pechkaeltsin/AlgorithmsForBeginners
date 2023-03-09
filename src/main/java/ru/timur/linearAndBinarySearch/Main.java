package main.java.ru.timur.linearAndBinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <DESCRIPTION>Линейный и бинарный поиск.
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
        System.out.println("\nЛинейный поиск. Номер элемента: " + linearSearch(arr1, element));
        if (binarySearch(arr2, element) == -1) {
            System.out.println("Бинарный поиск. Элемент отсутствует!");
        } else {
            System.out.println("Бинарный поиск. Номер элемента: " + binarySearch(arr2, element));
        }
        System.out.println("\nОтличные элементы массивов: ");
        compareLists(arr1, arr2);
    }

    public static int linearSearch(int[] arr, int element) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

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