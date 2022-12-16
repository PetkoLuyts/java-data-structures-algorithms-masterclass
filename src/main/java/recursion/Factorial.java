package recursion;

public class Factorial {
    public static void main(String[] args) {
        int num = 5;

        System.out.println(factorial(5));
    }

    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
