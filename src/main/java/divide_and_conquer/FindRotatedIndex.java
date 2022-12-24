package divide_and_conquer;

public class FindRotatedIndex {
    public static int findRotatedIndex(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int middle = 0;

        if (right > 0 && arr[left] >= arr[right]) {
            middle = (int) Math.floor((left + right) / 2);

            while (arr[middle] <= arr[middle + 1]) {
                if (arr[left] <= arr[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }

                middle = (int) Math.floor((left + right) / 2);
                if (middle + 1 > arr.length - 1) {
                    break;
                }

            }
            if (num >= arr[0] && num <= arr[middle]) {
                left = 0;
                right = middle;
            } else {
                left = middle + 1;
                right = arr.length - 1;
            }

        }
        while (left <= right) {
            middle = (int) Math.floor((left + right) / 2);

            if (num == arr[middle]) {
                return middle;
            }
            if (num > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
