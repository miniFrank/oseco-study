package leetcode.basic;

import java.util.*;

/**
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RecoveryBlankCharacter {

    private void aggregation(final String[] dictionary, String sentence, List<Integer> matchedLengthList) {
        for (String dic : dictionary) {
            if (sentence.contains(dic)) {
                System.out.println(dic);
                System.out.println(sentence);
                sentence = sentence.replaceFirst(dic, "");
                matchedLengthList.add(dic.length());
            }
        }

        String finalSentence = sentence;
        if (sentence.length() > 0 && Arrays.stream(dictionary).anyMatch(finalSentence::contains)) {
            aggregation(dictionary, sentence, matchedLengthList);
        }
    }

    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        List<Integer> matchedLengthList = new ArrayList<>();

        this.aggregation(dictionary, sentence, matchedLengthList);
        Integer matchedLength = matchedLengthList.stream().reduce(0, Integer::sum);
        System.out.println(len - matchedLength);
        return len - matchedLength;
    }

    public int _respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }

        System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        RecoveryBlankCharacter blankCharacter = new RecoveryBlankCharacter();
        blankCharacter._respace(new String[]{"potimzz"}, "potimzzpotimzz");
        blankCharacter._respace(new String[]{"vprkj", "sqvuzjz", "ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp", "spqzqtrqs",
                        "rkktkruzsjkrzqq", "rk", "k", "zkvdzqrzpkrukdqrqjzkrqrzzkkrr", "pzpstvqzrzprqkkkd",
                        "jvutvjtktqvvdkzujkq", "r", "pspkr", "tdkkktdsrkzpzpuzvszzzzdjj", "zk", "pqkjkzpvdpktzskdkvzjkkj",
                        "sr", "zqjkzksvkvvrsjrjkkjkztrpuzrqrqvvpkutqkrrqpzu"},
                "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr");
        blankCharacter._respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother");
    }
}
