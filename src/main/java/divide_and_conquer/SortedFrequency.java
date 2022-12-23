package divide_and_conquer;

public class SortedFrequency {
    public static int sortedFrequency(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int leftCount = 0;
        int rightCount = 0;

        while (left <= right) {
            int middle = (int) Math.floor((left + right) / 2);

            if (arr[middle] == num) {
                leftCount = middle;
                rightCount = middle;

                while (arr[leftCount] == num && leftCount >= 0) {
                    leftCount -= 1;
                }

                while (rightCount < arr.length && arr[rightCount] == num) {
                    rightCount += 1;
                }
                return rightCount - leftCount - 1;
            }
            if (arr[middle] < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
