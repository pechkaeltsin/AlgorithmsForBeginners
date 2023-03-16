package main.java.ru.timur.task2;

import java.util.Arrays;
import java.util.Random;

/**
 * Занятие 2
 *
 * @author fazylzyanov@reksoft.ru
 */
public class Main {
    public static void main(String[] args) {

        int [] array = {7, 3, 8, 5, 0, 2, 5, -1};
        int element = 5;
        System.out.println("Исходный массив:\n" + Arrays.toString(array));
        System.out.println("\nЗадание 1:\nСортировка выбором:\n" + Arrays.toString(selectionSort(array)));
        System.out.println("\nЗадание 2:\nСортировка пузырьком:\n" + Arrays.toString(bubbleSort(array)));
        System.out.println("\nЗадание 3:\nУдаление элемента " + element + ":\n" + Arrays.toString(removeElementFromArray(array, element)));
        minMidMax();
    }

    /**
     * Задание 1:
     * Реализовать сортировку выбором
     */
    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
        return array;
    }

    /**
     * Задание 2:
     * Реализовать сортировку пузырьком
     */
    public static int[] bubbleSort(int[] array) {

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }
        return array;
    }

    /**
     * Задание 3:
     * Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива (пропусков быть не должно).
     */

    public static int[] removeElementFromArray(int[] array, int element) {

        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                count++;
                if (array.length - 1 - i >= 0) System.arraycopy(array, i + 1, array, i, array.length - 1 - i);
                i--;
            }
        }

        int[] newArray = new int[array.length-count];
        if (array.length - count >= 0) System.arraycopy(array, 0, newArray, 0, array.length - count);
        return newArray;
    }

    /**
     * Задание 4:
     * Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
     */

    public static void minMidMax() {
        int[] array = new Random().ints(10, 0,10).toArray();
        System.out.println("\nЗадание 4\nСлучайный массив:\n" + Arrays.toString(array));

        double total = 0;
        double mid;
        double max = 0;
        double min = 0;

        for (int i : array) {
            total += i;
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        mid = total / array.length;
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Среднее: " + mid);
    }
}