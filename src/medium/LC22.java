package medium; /**
 * Generate Parentheses
 * 生成配对括号
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC22 {
    public static void main(String[] args) {
        int n = 0;
        List<String> r = new LC22().generateParenthesis(n);
        System.out.println(r.size());
        for (String s : r) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n, n);
        return res;
    }

    public void dfs(List<String> res, String s, int left, int right, int n) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (left > 0) {
            dfs(res, s + "(", left - 1, right, n);
        }
        if (right > left) {
            dfs(res, s + ")", left, right - 1, n);
        }
    }

    //too naive!
    public List<String> generateParenthesis1(int n) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("()");
        List<String> res = new ArrayList<>();
        for (String s : generateParenthesis(n - 1)) {
            String s1 = "()" + s;
            String s2 = s + "()";
            String s3 = "(" + s + ")";
            if (!res.contains(s1)) res.add(s1);
            if (!res.contains(s2)) res.add(s2);
            if (!res.contains(s3)) res.add(s3);
        }
        return res;
    }
}
