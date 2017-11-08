public class LC6 {
    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(new LC6().convert(s, 1));
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= numRows || numRows == 1) return s;
        String r = ""; //返回结果
        int T = (len / (2 * numRows - 2) + 1);   //周期数，每个周期有2n-2个数

        //第一行字符的下标为2tn-2t
        for (int t = 0; t < T; t++) {
            int index = 2 * t * numRows - 2 * t;
            if (index < len) r += s.charAt(index);
        }
        //第i行的首字符下标为i，后续每个字符与前一个字符下标之和为2kn-2k,k∈[1,2T-1]
        for (int i = 1; i < numRows - 1; i++) {
            r += s.charAt(i);
            int preindex = i;
            for (int k = 1; k <= 2 * T - 1; k++) {
                int index = 2 * k * numRows - 2 * k - preindex;
                if (index < len) r += s.charAt(index);
                preindex = index;
            }
        }
        //最后一行字符的下标为(2t+1)n-(2t+1)
        for (int t = 0; t < T; t++) {
            int index = (2 * t + 1) * numRows - 2 * t - 1;
            if (index < len) r += s.charAt(index);
        }
        return r;
    }
}
