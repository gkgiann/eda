package atividade02;

import java.util.Arrays;

public class Ordenacao implements Ordenacao_IF {

    @Override
    public boolean checaVetorOrdenado(int[] numeros) {
        for (int i = 0; i < numeros.length - 1; i++) {
            if (numeros[i] > numeros[i + 1])
                return false;
        }

        return true;
    }

    @Override
    public long bubbleSort(int[] numeros) {
        long before = System.nanoTime();

        int length = numeros.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    swap(numeros, j, j + 1);
                }
            }
        }

        long after = System.nanoTime();
        return after - before;

    }

    @Override
    public long selectionSort(int[] numeros) {
        long before = System.nanoTime();
        // 1, 2, 3
        int length = numeros.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (numeros[j] < numeros[minIndex]) {
                    minIndex = j;
                }
            }

            swap(numeros, i, minIndex);
        }

        long after = System.nanoTime();
        return after - before;

    }

    @Override
    public long insertionSort(int[] numeros) {
        long before = System.nanoTime();

        int length = numeros.length;
        for (int i = 1; i < length; i++) {
            int key = numeros[i];
            int j = i - 1;

            while (j > -1 && numeros[j] > key) {
                numeros[j + 1] = numeros[j];
                j--;
            }

            numeros[j + 1] = key;

        }

        long after = System.nanoTime();
        return after - before;

    }

    @Override
    public long mergeSort(int[] numeros) {
        long before = System.nanoTime();

        mergeSortAux(numeros);

        long after = System.nanoTime();
        return after - before;

    }

    private static void mergeSortAux(int[] array) {
        if (array.length == 1)
            return;

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        int i;
        for (i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        mergeSortAux(left);
        mergeSortAux(right);

        merge(array, left, right);

    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];

            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }

    }

    @Override
    public long quickSort(int[] numeros) {
        long before = System.nanoTime();

        quickSort(numeros, 0, numeros.length - 1);

        long after = System.nanoTime();

        return after - before;

    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);

        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (array[i] <= pivot) {
                i++;
            } else if (array[j] > pivot) {
                j--;
            } else {
                swap(array, i, j);
            }
        }

        swap(array, left, j);
        return j;
    }

    @Override
    public long random_quickSort(int[] numeros) {
        long before = System.nanoTime();

        random_quickSort(numeros, 0, numeros.length - 1);

        long after = System.nanoTime();
        return after - before;

    }

    private static void random_quickSort(int[] array, int left, int right) {
        if (left < right) {
            random_pivot(array, left, right);

            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);

        }
    }

    private static void random_pivot(int[] array, int left, int right) {
        int range = right - left + 1;
        int randomPivotIndex = (int) (Math.random() * range) + left;

        swap(array, left, randomPivotIndex);
    }

    @Override
    public long quickSort_Java(int[] numeros) {
        long before = System.nanoTime();

        Arrays.sort(numeros);

        long after = System.nanoTime();
        return after - before;

    }

    @Override
    public long countingSort(int[] numeros) {
        long before = System.nanoTime();

        int[] result = new int[numeros.length];
        countingSort(numeros, result, numeros.length);

        long after = System.nanoTime();
        return after - before;

    }

    private static void countingSort(int[] numeros, int[] result, int k) {
        int[] aux = new int[k];

        for (int i = 0; i < numeros.length; i++) {
            aux[numeros[i] - 1] += 1;
        }

        for (int i = 1; i < aux.length; i++) {
            aux[i] += aux[i - 1];
        }

        for (int i = numeros.length - 1; i >= 0; i--) {
            result[aux[numeros[i] - 1] - 1] = numeros[i];
            aux[numeros[i] - 1] -= 1;
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
