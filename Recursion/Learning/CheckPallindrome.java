public class CheckPallindrome {
    public static void main(String[] args) {
        String str = "MADAM";
        System.out.println(checkPallindrome(str, 0));
    }

    public static boolean checkPallindrome(String str, int ptr) {
        if (ptr >= str.length() / 2)
            return true;
        if (str.charAt(ptr) != str.charAt(str.length() - ptr - 1))
            return false;
        return checkPallindrome(str, ptr+1);
    }
}
