package recursion;

public class CapitalizeWord {
    public static void main(String[] args) {
        String str = "i love java";

        System.out.println(capitalizeWord(str));
    }

    public static String capitalizeWord(String str){
        if(str.isEmpty()) {
            return str;
        }

        char chr = str.charAt(str.length() - 1);

        if(str.length() == 1) {
            return Character.toString(Character.toUpperCase(chr));
        }

        if((str.substring(str.length() - 2, str.length() - 1).equals(" "))) {
            chr = Character.toUpperCase(chr);
        }

        return capitalizeWord(str.substring(0, str.length() - 1)) + Character.toString(chr);
    }
}
