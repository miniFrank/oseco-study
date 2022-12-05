package leetcode.basic;

public class PalindromeSolution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int old = x;
        int y = 0;

        while (x != 0) {
            if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
                break;
            }

            y = y * 10 + x % 10;
            x /= 10;
        }

        return old == y;
    }

    public static void main(String[] args) {
        System.out.println(PalindromeSolution.isPalindrome(121));
        System.out.println(PalindromeSolution.isPalindrome(-121));
        int x = -1000;

        System.out.println(~(x / 3));
        System.out.println(x / 3);
    }
}
