package easy;

/**
 * 最长公共前缀
 */
public class LC14 {
    public static void main(String[] args) {
        String[] strs = {"a", "ab"};
        System.out.println(new LC14().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int i = 0;
        boolean flag = true;
        while (flag) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            i++;
        }
        return strs[0].substring(0, i - 1);
    }
}
