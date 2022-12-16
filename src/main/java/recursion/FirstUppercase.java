package recursion;

public class FirstUppercase {
    public static void main(String[] args) {
        String str = "soMe Text";

        System.out.println(first(str));
    }

    public static char first(String str) {
        if (str.isEmpty()) {
            return ' ';
        }

        if (Character.isUpperCase(str.charAt(0))) {
            return str.charAt(0);
        } else {
            return first(str.substring(1, str.length()));
        }
    }
}
