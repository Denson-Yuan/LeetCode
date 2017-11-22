/**
 * 整数转换成罗马数字
 */
public class LC12 {
    public static void main(String[] args) {
        int num = 999;
        System.out.println(new LC12().intToRoman(num));
    }

    public String intToRoman(int num) {
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};// 个位数
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};// 整十
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};// 整百
        String[] M = {"", "M", "MM", "MMM"};// 整千
        return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10];
    }
}
