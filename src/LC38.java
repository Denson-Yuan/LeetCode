/**
 * Count and Say
 */
public class LC38 {
    public static void main(String[] args) {
        System.out.println(new LC38().countAndSay(10));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s1 = "1";
        String s2 = "";
        while (n-- > 1) {
            char c = s1.charAt(0);
            int cnt = 0;
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i)==c) cnt++;
                else{
                    s2 = s2 + cnt + c;
                    c = s1.charAt(i);
                    cnt = 1;
                }
            }
            s2 = s2 + cnt + c;
            s1 = s2;
            s2 = "";
        }
        return s1;
    }
}
