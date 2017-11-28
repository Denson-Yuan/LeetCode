package easy;

/**
 * 整数逆序
 */
public class LC7 {
    public static void main(String[] args) {
        System.out.println(new LC7().reverse(122332222));
    }

    public int reverse(int x) {
        int abs = x;
        if (x < 0) abs = -x;
        String s = "";
        while (abs != 0) {
            s += abs % 10;
            abs = abs / 10;
        }
        int result;
        try {
            if (x < 0) result = Integer.parseInt(s) * -1;
            else result = Integer.parseInt(s);
        }catch (Exception e){
            result = 0;
        }
        return result;
    }


//Better Answer 1：利用long过渡
    public int reverse1(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }


//Better Answer 2
    public int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
                return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
