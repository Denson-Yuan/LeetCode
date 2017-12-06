package easy;

/**
 * Climbing Stairs
 * n级台阶，每次可以走1步或两步，一共有多少种走法
 */
public class LC70 {
    public static void main(String[] args) {
        int n = 44;
        System.out.println(new LC70().climbStairs(n));
        System.out.println(new LC70().climbStairs1(n));
    }

    /**
     * CS(n+1) = CS(n) + CS(n-1)
     * 斐波拉契数列
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int c1 = 1, c2 = 2;
        while (n-- > 2) {
            int tmp = c2;
            c2 = c1 + c2;
            c1 = tmp;
        }
        return c2;
    }

    public int climbStairs1(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            /**
             * int tmp = b;
             * b = a + b;
             * a = tmp;
             */
            a = (b += a) - a;
        }
        return a;
    }
}
