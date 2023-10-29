import java.util.Arrays;

class InsertionSort {
    void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        int[] arr = { 9, 5, 1, 4, 3 };
        InsertionSort is = new InsertionSort();
        is.insertionSort(arr);
        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }
}
