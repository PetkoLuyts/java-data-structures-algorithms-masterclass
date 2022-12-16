package recursion;

public class RecursiveRange {
    public static void main(String[] args) {
        int num = 6;

        System.out.println(recursiveRange(num));
    }

    public static int recursiveRange(int num) {
        if (num <= 0) {
            return  0;
        }

        return num + recursiveRange(num - 1);
    }
}
