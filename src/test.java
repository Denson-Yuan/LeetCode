import java.text.DecimalFormat;

public class test {

    public static void main(String[] args){
        System.out.println(Math.floor(100*Math.random()));

        double price = 1.22990741;
        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p=decimalFormat.format(price);//format 返回的是字符串

        System.out.println(p);
    }
}
