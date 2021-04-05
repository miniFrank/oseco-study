package leetcode.basic;

public class BinaryNumberOperation {

    public static String add(String s1, String s2) {
        int maxLen = Math.max(s1.length(), s2.length());
        int dis1 = maxLen - s1.length();
        int dis2 = maxLen - s2.length();
        while (dis1 > 0) {
            s1 = "0" + s1;
            dis1--;
        }
        while (dis2 > 0) {
            s2 = "0" + s2;
            dis2--;
        }

        int c1;
        int c2;
        int rest = '0';
        StringBuffer sb = new StringBuffer();
        //1 + 1 + 1  = 147
        //1 + 0 + 0 = 49 + 48 + 48 = 145
        //1 + 1 + 0 = 49 + 49 + 48 = 146
        //0 + 0 + 0 = 144
        for (int i = s1.length() - 1; i >= 0; i--) {
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            int sum = c1 + c2 + rest;
            if (sum == 144 || sum == 145) {
                if (sum % 2 == 0) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
                rest = '0';
            } else {
                if (sum % 2 != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                rest = '1';
            }
        }
        if (rest == '1') {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("rt:" + BinaryNumberOperation.add("10001", "101"));
        System.out.println("rt:" + BinaryNumberOperation.add("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        char ch1 = '0';
        char ch2 = '1';
        System.out.println((int) ch1);
        System.out.println((int) ch2);
    }
}
