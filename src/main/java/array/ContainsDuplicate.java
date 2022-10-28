package array;

import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 8, 5};

        boolean containsDuplicate = containsDuplicate(nums);

        System.out.println(containsDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> duplicates = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!duplicates.containsKey(nums[i])) {
                duplicates.put(nums[i], 1);
            } else {
                return true;
            }
        }

        return false;
    }
}
