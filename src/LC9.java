/**
 * 判断一个整数是否是回文数字
 */
public class LC9 {
    public static void main(String[] args) {
        int x = 1874994781;
        System.out.println(new LC9().isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int n = 10, m = 10;
        while (x / 10 >= n) n = n * 10;
        while (n >= m) {
            if (x / n % 10 != x % m / (m / 10)) return false;
            n /= 10;
            m *= 10;
        }
        return true;
    }

//Wrong Answer!!!
//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        int n = 10;
//        while (x >= n * 10) n = n * 10;
//        while (x >= 10) {
//            if (x / n != x % 10) return false;   //头尾相等
//            x = (x % n) / 10;    //掐头去尾
//            n = n / 100;
//        }
//        return true;
//    }
}
