package leetcode.basic;

/**
 * KMP算法（全称Knuth-Morris-Pratt字符串查找算法，由三位发明者的姓氏命名）是可以在文本串s中快速查找模式串p的一种算法。
 * 参考地址：https://www.cnblogs.com/Yintianhao/p/9996524.html、https://blog.csdn.net/v_july_v/article/details/7041827
 */
public class KMP {
    public static void main(String[] args) throws Exception {
        String source = "aababababca";
        String target = "abababca";
        int[] nextArr = getNext(target);
        System.out.println(nextArr);
        int k = KMP(source, target, nextArr);
        System.out.println(k);
    }

    /**
     * KMP算法
     *
     * @param next        next数组
     * @param modelString 模式串
     * @param mainString  主串
     * @return 匹配的第一个位置
     */
    public static int KMP(String mainString, String modelString, int[] next) {
        int i = 0;
        int j = 0;
        while (i < mainString.length() && j < modelString.length()) {
            if (-1 == j || mainString.charAt(i) == modelString.charAt(j)) {
                i++;
                j++;
            } else {
                //不相等,滑动
                j = next[j];
            }
        }
        if (j == modelString.length()) {
            //如果最后j到达模式串的尾部,则说明匹配上了
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * @param modelString 模式字符串
     *                    求next数组
     */
    public static int[] getNext(String modelString) {
        int[] next = new int[modelString.length() + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < modelString.length()) {
            if (j == -1 || modelString.charAt(i) == modelString.charAt(j)) {
                //相等的情况
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }
}
