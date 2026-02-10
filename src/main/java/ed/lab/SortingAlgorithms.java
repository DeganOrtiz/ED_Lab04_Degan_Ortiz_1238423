package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    private static final Random rand = new Random();

    // 🔹 Pivote = último elemento
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSortHigh(array, 0, array.length - 1);
    }

    // 🔹 Pivote = primer elemento
    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSortLow(array, 0, array.length - 1);
    }

    // 🔹 Pivote = aleatorio
    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSortRandom(array, 0, array.length - 1);
    }

    // ================= IMPLEMENTACIONES =================

    private static <T extends Comparable<T>> void quickSortHigh(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionHigh(arr, low, high);
            quickSortHigh(arr, low, pi - 1);
            quickSortHigh(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> void quickSortLow(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionLow(arr, low, high);
            quickSortLow(arr, low, pi - 1);
            quickSortLow(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> void quickSortRandom(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionRandom(arr, low, high);
            quickSortRandom(arr, low, pi - 1);
            quickSortRandom(arr, pi + 1, high);
        }
    }

    // ================= PARTICIONES =================

    // Último elemento como pivote
    private static <T extends Comparable<T>> int partitionHigh(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Primer elemento como pivote
    private static <T extends Comparable<T>> int partitionLow(T[] arr, int low, int high) {
        T pivot = arr[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    // Pivote aleatorio
    private static <T extends Comparable<T>> int partitionRandom(T[] arr, int low, int high) {
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high); // lo movemos al final
        return partitionHigh(arr, low, high);
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
