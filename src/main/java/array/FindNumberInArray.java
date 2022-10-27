package array;

public class FindNumberInArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6};

        int result = searchInArray(nums, 2);

        System.out.println(result);
    }

    public static int searchInArray(int[] intArray, int valueToSearch) {
        for (int i = 0; i < intArray.length; i++) {
            if (valueToSearch == intArray[i]) {
                return i;
            }
        }

        throw new IllegalArgumentException("Value could not be found!");
    }

}
