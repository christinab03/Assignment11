import java.util.Arrays;

public class GenericSort {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Swap array[j] and array[j+1]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length <= 1)
            return;

        int mid = array.length / 2;
        T[] leftArray = Arrays.copyOfRange(array, 0, mid);
        T[] rightArray = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] leftArray, T[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftLength) {
            array[k++] = leftArray[i++];
        }

        while (j < rightLength) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        Integer[] arr1 = {5, 2, 9, 1, 5, 6};
        System.out.println("Array before bubble sort: " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("Array after bubble sort: " + Arrays.toString(arr1));

        Integer[] arr2 = {5, 2, 9, 1, 5, 6};
        System.out.println("Array before merge sort: " + Arrays.toString(arr2));
        mergeSort(arr2);
        System.out.println("Array after merge sort: " + Arrays.toString(arr2));
    }
}
