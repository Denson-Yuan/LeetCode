package other;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 说明：
 * 1.程序假定题目中的M个用户为相同的M个用户（如一个M人群），
 * 且已经事先给每个用户安排好一个序号，
 * 每个人点击红包后将得到相应位置的红包金额
 * <p>
 * 2.假定发红包次数N>3且M>=4,否则一定会有人拿到运气王次数超过30%*N次
 * （ 需满足 M*0.3N > N ）
 * <p>
 * （若每次M个用户不一定相同，则需要定义用户id相关信息）
 */
public class RedEnvelopes {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("请输入发红包次数：");
        int n = cin.nextInt();
        System.out.println("请输入人数：");
        int m = cin.nextInt();

        System.out.println("请输入红包总金额：");
        double money = cin.nextDouble();

        while (money < m * 0.01) {
            System.out.println("单个红包最少1分钱, 请重新输入：");
            money = cin.nextDouble();  //每次发红包前输入红包金额
        }

        new RedEnvelopes().giveNRedEnvelope(n, m, money);

        cin.close();
    }


    /**
     * @param m：人数
     * @param money：本次红包总金额
     */
    private void giveNRedEnvelope(int n, int m, double money) {

        int[] count = new int[m];   //记录每个人获得运气王的次数
        for (int time = 0; time < n; time++) {
            double[] result = new double[m];

            // 存放m个随机整数，根据每个整数占总和的比例决定红包金额
            double[] rand = new double[m];

            // 标志本次生成金额是否满足要求
            boolean flag = false;

            double sum = 0;     //记录rand数组的和
            double max = 0;     //记录最大红包金额
            int maxIndex = 0;  //记录最大金额红包位置

            while (!flag) {  //若不满足条件重复生成红包金额序列
                flag = true;    //重置标志位

                sum = 0;
                max = 0;
                maxIndex = 0;

                //生成M个随机整数
                for (int i = 0; i < m; i++) {
                    rand[i] = Math.floor(100 * Math.random());
                    sum = sum + rand[i];
                    if (rand[i] > max) {
                        max = rand[i];
                        maxIndex = i;
                    }
                }

                //检查运气王次数是否超出限制(n>3且m>=4才有意义)
                //以及单个红包大小是否超90%(n>1才有意义)
                if (n >= 3 && m >= 4 && count[maxIndex] + 1 > 0.3 * n || n > 1 && rand[maxIndex] / sum > 0.9) {
                    flag = false;
                }
            }

            count[maxIndex] = count[maxIndex] + 1;

            DecimalFormat decimalFormat = new DecimalFormat(".00");
            double rest = money;   //剩余金额

            for (int i = 0; i < m - 1; i++) {
                result[i] = Double.parseDouble(decimalFormat.format(rand[i] / sum * money));

                //若舍入后金额为0,或者剩下金额不足后面每人至少0.01,则调整为0.01
                if (result[i] == 0 || rest - result[i] < 0.01 * (m - i - 1)) {
                    result[i] = 0.01;  //单个至少1分钱
                }

                rest = Double.parseDouble(decimalFormat.format(rest - result[i]));
            }

            //若剩余金额为0，则将最后一个金额设为0.01，并将前面任意一个非运气王且金额大于0.01的减少0.01
            // (如果减少了运气王的有可能就不是运气王了)
            if (m > 1 && rest == 0) {
                rest = 0.01;
                for (int i = 0; i < m - 1; i++) {
                    if (result[i] > 0.01 && i != maxIndex) {
                        result[i] = result[i] - 0.01;
                        break;
                    }
                }
            }

            result[m - 1] = rest;
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            System.out.println("手气最佳：" + maxIndex);
        }

    }
}