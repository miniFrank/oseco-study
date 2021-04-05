package leetcode.basic;

public class BasicTitleCollection {
    /**
     * 解法1
     *
     * @param x
     * @return
     */
    public static int reserveNumberViaString(int x) {
        String numString = String.valueOf(x);
        char[] chs = new char[numString.length()];
        int start = 0;
        for (int i = numString.length() - 1; i >= 0; i--) {
            if (numString.charAt(i) != '-') {
                chs[start++] = numString.charAt(i);
            }
        }
        double newResult = Double.parseDouble(new String(chs));
        if (newResult < Integer.MIN_VALUE || newResult > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) (x < 0 ? -newResult : newResult);
    }

    private static int intLength(int x) {
        int len = 1;
        int rest = x / 10;
        while (Math.abs(rest) > 0) {
            rest = rest / 10;
            len++;
        }

        return len;
    }

    /**
     * @param x
     * @return
     */
    public static int reserveNumber(int x) {
        int len = intLength(x);
        int newNum = 0;
        int _x = x;
        while (len-- > 0) {
            if (newNum <= Integer.MIN_VALUE || newNum >= Integer.MAX_VALUE) {
                newNum = 0;
                break;
            }
            newNum += (_x % 10) * Math.pow(10, len);
            _x = _x / 10;
        }

        return newNum;
    }

    public static int reserveNumber2(int x) {
        int[] numArray = new int[10];
        int _x = x / 10;


        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(reserveNumber(0));
//        System.out.println(reserveNumber(1));
//        System.out.println(reserveNumber(-10));
//        System.out.println(reserveNumber(-1023));
//        System.out.println(reserveNumber(-10213213));
//        System.out.println(reserveNumber(1534236469));
//        System.out.println(reserveNumber(-2147483648));
//        System.out.println(reserveNumberViaString(0));
//        System.out.println(reserveNumberViaString(1));
//        System.out.println(reserveNumberViaString(-100));
//        System.out.println(reserveNumberViaString(-10));
//        System.out.println(reserveNumberViaString(10));
//        System.out.println(reserveNumberViaString(1534236469));
//        System.out.println(reserveNumberViaString(-2147483648));
//        System.out.println(-0 % 10);

//        LocalDateTime startTime = LocalDateTime.of(LocalDate.now().minusDays(7), LocalTime.of(0, 0, 0));
//        System.out.println(startTime);
    }
}
