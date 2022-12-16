package recursion;

import java.util.Arrays;

public class SomeRecursive {

    public static class OddFunction {
        boolean run(int num) {
            if (num % 2 == 0) {
                return false; }
            else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2 ,3 ,4};
        OddFunction odd = new OddFunction();

        System.out.println(someRecursive(arr, odd));
    }

    public static boolean someRecursive(int[] arr, OddFunction odd) {
        if (arr.length == 0) {
            return false;
        } else if (odd.run(arr[0]) == false) {
            return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
        } else {
            return true;
        }
    }
}
