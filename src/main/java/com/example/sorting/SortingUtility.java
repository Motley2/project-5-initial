package com.example.sorting;

public class SortingUtility {

    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        int pos = 0;
        while (pos < a.length) {
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos++;
            } else {
                swap(a, pos, pos - 1);
                pos--;
            }
        }
    }

    public static <T extends Comparable<T>> void cocktailShakerSort(T[] A) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = A.length - 2; i >= 0; i--) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int[] gaps = {711, 342, 123, 64, 24, 11, 5, 1};
        for (int gap : gaps) {
            for (int i = gap; i < a.length; i++) {
                T temp = a[i];
                int j;
                for (j = i; j >= gap && a[j - gap].compareTo(temp) > 0; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}