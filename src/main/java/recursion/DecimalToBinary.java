package recursion;

public class DecimalToBinary {
    public static void main(String[] args) {
        int n = 10;

        int result = decimalToBinary(n);

        System.out.println(result);
    }

    public static int decimalToBinary(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }

        return n % 2 + 10 * decimalToBinary(n / 2);
    }
}
