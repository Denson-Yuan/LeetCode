/*
 * 最大无重复子串
 */
public class LC3 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new LC3().lengthOfLongestSubstring(s));
    }


    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[256];
        int start = 0;
        int max = 0;
        for (int i = 0; i != s.length(); i++) {
            if (pos[s.charAt(i)] > start) {
                start = pos[s.charAt(i)];
            }
            pos[s.charAt(i)] = i + 1;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}


/*version 1
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        for (int len = s.length(); len > 1; len--) {
            for(int i = 0;i+len-1<s.length();i++){
                if(noRepeating(s.substring(i,i+len))) {
                    return len;
                }
            }
        }
        return 1;
    }

    public boolean noRepeating(String s) {
        if (s.length() == 1)
            return true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
*/