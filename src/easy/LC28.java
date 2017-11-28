package easy;

/**
 * Implement strStr()
 * 寻找子串位置
 */
public class LC28 {
    public static void main(String[] args) {
        String haystack = "misspi", needle = "pi";
        System.out.println(new LC28().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        // if (needle.length() == 0) return 0;
        // if (haystack.equals(needle)) return 0;
        // <= , 不是 < !!! 则不用考虑上述情况
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}
