package array;

public class MaxProductOfTwoIntegers {
    public static void main(String[] args) {
        int[] nums = {40, 90, 60, 80};

        String result = maxProduct(nums);

        System.out.println(result);
    }

    public static String maxProduct(int[] intArray) {
        int maxProduct = 0;
        String pairs = "";

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] * intArray[j] > maxProduct) {
                    maxProduct = intArray[i] * intArray[j];
                    pairs = intArray[i] + "," + intArray[j];
                }
            }
        }

        return pairs;
    }
}
