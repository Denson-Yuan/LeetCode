package easy;

/**
 * Add Binary
 */
public class LC67 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "111111";
        System.out.println(new LC67().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        String res = "";
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            char ai = i >= 0 ? a.charAt(i) : '0';
            char bj = j >= 0 ? b.charAt(j) : '0';
            int tmp = ai ^ bj ^ carry;
            res = tmp + res;
            if (tmp == 0 && (ai == '1' || bj == '1' || carry == 1)) carry = 1;
            else if (ai == '1' && bj == '1' && carry == 1) carry = 1;
            else carry = 0;
            i--;
            j--;
        }
        if (carry == 1) return carry + res;
        return res;
    }
}
