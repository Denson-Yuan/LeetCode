/**
 * 字符串转换成整数
 */
public class LC8 {
    public static void main(String[] args) {
        System.out.println(new LC8().myAtoi("2147483648"));
    }

    public int myAtoi(String str) {
        int index = 0, total = 0, sign = 1;
        if (str.length() == 0) return 0;
        //头部空格
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        //符号
        if (index < str.length() && str.charAt(index) == '+'||str.charAt(index) == '-') {
            sign = str.charAt(index) == '+'?1:-1;
            index++;
        }

        while (index < str.length()) {
            int cur = str.charAt(index) - '0';
            if (cur < 0 || cur > 9) break;
            //判断是否溢出
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < cur)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = total * 10 + cur;
            index++;
        }
        return sign * total;
    }
}
