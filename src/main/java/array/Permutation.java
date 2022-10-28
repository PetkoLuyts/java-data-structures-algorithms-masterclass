package array;

import java.util.HashMap;

public class Permutation {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {5,1,2,3,4};

        boolean arePermutations = permutation(array1, array2);

        System.out.println(arePermutations);
    }

    public static boolean permutation(int[] array1, int[] array2){
        if (array1.length != array2.length) {
            return false;
        }

        HashMap<Integer, Integer> numbersEncountered = new HashMap<>();

        for (int i = 0; i < array1.length; i++) {
            if (!numbersEncountered.containsKey(array1[i])) {
                numbersEncountered.put(array1[i], 1);
            }
        }

        for (int i = 0; i < array2.length; i++) {
            if (!numbersEncountered.containsKey(array2[i])) {
                return false;
            }
        }

        return true;
    }
}
