package array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] numbers = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        int missingNumber = missingNumber(numbers);

        System.out.println(missingNumber);
    }

    public static int missingNumber(int[] nums) {
        int sumOfMissingNumberArr = 0;

        for (int i = 0; i < nums.length; i++) {
            sumOfMissingNumberArr += nums[i];
        }

        int count = nums.length;
        int sumWithoutMissingNumber = (count * (count + 1)) / 2;

        return sumWithoutMissingNumber - sumOfMissingNumberArr;
    }
}
