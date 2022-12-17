package array;

import java.util.Arrays;

public class MiddleFunction {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println(Arrays.toString(middle(nums)));
    }

    public static int[] middle(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length - 1);
    }
}
