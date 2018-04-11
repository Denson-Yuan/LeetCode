package other;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：写一个发红包程序，连续发N次红包（每次红包总金额相同），每个红包随机分给M个人
 * 要求
 * （1）最大红包金额不能超过红包总金额的90%；
 * （2）连续N次发红包，获得最佳手气（红包金额最高）的人，得到最佳手气的次数不超过总次数的30%；
 * （3）单个红包最小1分钱；
 *
 * @author Li
 * 红包分配思路：
 * 前0.3N次，最大金额在哪个位置都行，因为不可能有人得到最佳手气超过总次数的30%；
 * n0=0.3N向下取整，m0=N/n0向下取整，k*n0< n <=(k+1)*n0中最后k个红包不能为最大值，如果有达到或者加上本次达到最佳手气0.3N次，就让此最大金额与后面一个红包交换位置
 */
public class RedEnvelopes1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();// 连续发N次红包（每次红包总金额相同）
        int M = cin.nextInt();// 每个红包随机分给M个人
        double money = cin.nextDouble();// 每次红包总金额相同为money
        int n0 = N * 3 / 10;// <=0.3N
        int m0 = N / n0;// 能达到n0的人数最大值
        if (N >= 4 && N <= (N * 3 / 10) * M) {
            if (money >= 0.01 * M) {
                HashMap<Integer, List<Double>> map = new HashMap<Integer, List<Double>>();
                for (int i = 1; i <= N; i++) {
                    List<Double> array = giveRedPacket(M, money);
                    if (i <= n0) {// 前0.3N次，最大金额在哪个位置都行
                        Collections.shuffle(array);// 打乱红包顺序
                    } else {// 大于前0.3N次，最大金额位置受限
                        double s0 = array.get(array.size() - 1);// 取红包最大值
                        Collections.shuffle(array);// 打乱红包顺序
                        for (int j = 1; j <= m0; j++) {
                            if (i > j * n0 && i <= (j + 1) * n0) {// 在j*n0到(j+1)*n0次，只要最后j个红包不是最大值就可以
                                List<Double> li = new ArrayList<Double>();
                                boolean bo = false;
                                for (int k = 0; k < j; k++) {
                                    li.add(array.get(array.size() - (k + 1)));
                                    if (s0 == li.get(k)) {// 如果最后k+1个红包中有最大值，打乱重排
                                        bo = true;
                                        break;
                                    }
                                }
                                while (bo) {
                                    Collections.shuffle(array);// 打乱红包顺序
                                    bo = false;
                                    li.removeAll(li);
                                    for (int k = 0; k < j; k++) {
                                        li.add(array.get(array.size() - (k + 1)));
                                        if (s0 == li.get(k)) {
                                            bo = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    map.put(i, array);
                }
                for (int i = 1; i <= N; i++) {
                    List<Double> array = map.get(i);
                    for (Double a : array) {
                        System.out.print(a + "  ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("单个红包金额不能低于0.01元");
            }
        } else {
            System.out.println("N<4次时，或者N>(N*3/10)*M时，不能满足获得最佳手气（红包金额最高）的人，得到最佳手气的次数不超过总次数的30%");
        }
    }

    // 生成红包
    private static List<Double> giveRedPacket(int M, double money) {
        List<Double> array = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < M; i++) {
            array.add(Math.random() + 0.01);
            sum += array.get(i);
        }
        for (int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) / sum * money);
        }
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {// 将钱进行分配
            if (array.get(i) <= 0.01) {// 不足0.01的直接分配0.01
                array.set(i, 0.01);
            } else if (i == array.size() - 1) {// 将剩下的money分给最后一个人
                BigDecimal bd = new BigDecimal("0");
                for (int j = 0; j < array.size() - 1; j++) {
                    BigDecimal b = new BigDecimal(Double.toString(array.get(j)));
                    bd = bd.add(b);
                }
                BigDecimal moneyb = new BigDecimal(Double.toString(money));
                array.set(i, moneyb.subtract(bd).doubleValue());
            } else {
                array.set(i, (int) (array.get(i) * 100) * 1.0 / 100);
            }
        }
        while (array.get(array.size() - 1) - 0.9 * money > 0) {
            array = giveRedPacket(M, money);
        }
        return array;
    }

}
