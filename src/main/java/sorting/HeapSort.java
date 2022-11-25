package sorting;

public class HeapSort {
    int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        BinaryHeap binaryHeap = new BinaryHeap(arr.length);

        for (int i = 0; i < arr.length; i++) {
            binaryHeap.insert(arr[i], "Min");
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = binaryHeap.extractHeadOfBinaryHeap("Min");
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
