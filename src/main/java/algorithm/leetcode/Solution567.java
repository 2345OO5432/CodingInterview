package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/08
 */
public class Solution567 {

    /**
     * 即利用一个宽度为len2的滑动窗口，在字符串B中滑动，当新字符从右边进来时，将数组位上的值++，从左边出去时，将值--，
     * 并判断每一时刻，对于一个数组，每一个字符都被使用了(即数组中每个位置都为0)。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }

        int[] array = new int[26];
        // 窗口初始位置
        for (int i = 0; i < len1; ++i) {
            ++array[s1.charAt(i) - 'a'];
            --array[s2.charAt(i) - 'a'];
        }

        if (isAllZero(array)) {
            return true;
        }

        for (int i = len1; i < len2; ++i) {
            --array[s2.charAt(i) - 'a'];
            ++array[s2.charAt(i - len1) - 'a'];
            if (isAllZero(array)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAllZero(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (0 != array[i]) {
                return false;
            }
        }
        return true;
    }
}
