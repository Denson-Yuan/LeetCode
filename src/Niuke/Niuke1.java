package Niuke;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */


//Wrong Answer!!!!
public class Niuke1 {

    public static void main(String[] args) {
        int[][] a = {{1,2,8,9}, {2, 4, 9,12}, {4,7,10,13},{6,8,11,15}};
        int target = 15;
        System.out.println(new Niuke1().Find(target, a));

    }

    boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;

        int left = 0, right = col - 1, mid = right / 2;
        int mup = array[0][mid];
        int mdn = array[row - 1][mid];

        while (target < mup || target > mdn) {
            if (right == left) return false;
            if (left == right - 1) {
                if(target > array[row - 1][left] && target < array[0][right]) return false;
                if(mid == left) mid=mid+1;
            }
            if (target < mup) right = mid;
            else left = mid;

            mid = (left + right) / 2;
            mup = array[0][mid];
            mdn = array[row - 1][mid];
        }
        for (int i = 0; i < row; i++) {
            if (array[i][mid] == target)
                return true;
        }
        return false;
    }

}
