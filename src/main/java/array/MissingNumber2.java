package array;

public class MissingNumber2 {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 6};

        missingNumber(myArray, 6);
    }

    public static int missingNumber(int[] arr, int totalCount) {
        int expectedSum = 0;
        int actualSum = 0;

        for(int i = 1; i <= totalCount; ++i) {
            expectedSum += i;
        }

        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        System.out.println(expectedSum);

        return expectedSum - actualSum;
    }

}
