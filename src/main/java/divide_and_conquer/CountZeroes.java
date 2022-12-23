package divide_and_conquer;

public class CountZeroes {
    public static int countZeroes(int[] array) {
        int left = 0;
        int right = array.length;
        while (left <= right) {
            int middle = (int) (left + right) / 2;
            if (array[middle] == 1) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return array.length - left;
    }
}
