package easy;

/**
 * 罗马数字转换成整数
 */

public class LC13 {
    public static void main(String[] args) {
        String s = "MMMCMXCIX";
        System.out.println(new LC13().romanToInt(s));
        System.out.println(new LC13().romanToInt1(s));
    }

    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        String ch = "IVXLCDM";
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) sum -= 1;
            else if (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) sum -= 10;
            else if (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) sum -= 100;
            else sum += num[ch.indexOf(s.charAt(i))];
        }
        sum += num[ch.indexOf(s.charAt(s.length() - 1))];
        return sum;
    }

    public int romanToInt1(String s) {
        if (s.length() == 0) return 0;
        String ch = "IVXLCDM";
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        int sum = num[ch.indexOf(s.charAt(s.length() - 1))];
        for (int i = 0; i < s.length() - 1; i++) {
            if (num[ch.indexOf(s.charAt(i))] < num[ch.indexOf(s.charAt(i + 1))])
                sum -= num[ch.indexOf(s.charAt(i))];
            else
                sum += num[ch.indexOf(s.charAt(i))];
        }
        return sum;
    }
}
