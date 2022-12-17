package array;

import java.util.Arrays;
import java.util.Collections;

public class BestScore {
    public static void main(String[] args) {
        Integer[] myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};

        System.out.println(firstSecond(myArray));
    }

    public static String firstSecond(Integer[] myArray) {
        Integer[] arr = myArray;
        Arrays.sort(arr, Collections.reverseOrder());
        int first = arr[0];
        Integer second = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != first) {
                second = arr[i];
                break;
            }
        }

        return first + " " + second;
    }
}
