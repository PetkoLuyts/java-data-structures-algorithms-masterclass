package recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 578;

        int result = sumOfDigits(n);

        System.out.println(result);
    }

    public static int sumOfDigits(int n) {
        if (n == 0 || n < 0) {
            return 0;
        }

        return n % 10 + sumOfDigits(n / 10);
    }
}
