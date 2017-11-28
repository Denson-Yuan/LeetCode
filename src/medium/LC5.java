package medium;

/**
 * 最长回文子串
 */
public class LC5 {
    public static void main(String[] args) {
        String s = "dfhashadsna;scnaliwehfshfaisdha;";
//        String s = "babadab";
        System.out.println(new LC5().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        double radius = 0, center = 0;
        double c = 0, r;
        while (c < s.length()) {
            if (c == (int) c) r = 0;
            else r = 0.5;

            while (c + r < s.length() && c - r >= 0 && s.charAt((int) (c + r)) == s.charAt((int) (c - r))) {
                r = r + 1;
            }
            if (r - 1 > radius) {
                radius = r - 1;
                center = c;
            }
            //若连续两个字符相同，考虑以它们的中间位置为对称中心
            if (c != (int) c || c + 1 < s.length() && s.charAt((int) c) == s.charAt((int) (c + 1))) {
                c = c + 0.5;
            } else
                c = c + 1;
        }
        return s.substring((int) (center - radius), (int) (center + radius + 1));
    }

    //没考虑长度为偶数的情况
    public String longestPalindrome1(String s) {
        if (s.length() == 0) return "";
        int maxj = 0, maxi = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (i + j < s.length() && i - j >= 0 && s.charAt(i + j) == s.charAt(i - j)) {
                j++;
            }
            if (j - 1 > maxj) {
                maxj = j - 1;
                maxi = i;
            }
        }
        return s.substring(maxi - maxj, maxi + maxj + 1);
    }
}

