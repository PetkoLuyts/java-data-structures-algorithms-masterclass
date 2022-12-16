package recursion;

public class Reverse {
    public static void main(String[] args) {
        String str = "java";

        System.out.println(reverse(str));
    }

    public static String reverse(String str)
    {
        if (str.isEmpty()) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }
}
