package test.com.tmtc.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Function:
 *
 * @auther: hbwhypw
 * Date: 2015/10/30 14:50
 */
public class NumberFormatTest {
    public static void test1(String[] args) {
        DecimalFormat df = new DecimalFormat("000000");
        String str2 = df.format(Integer.parseInt("23"));
        System.out.println(str2);
    }

    public static void test2() {
//        if (Pattern.matches("/[`~!@#$%^&*()_+<>?:\"{},.\\/;'[\\]]/", "杨彭伟")) {
//            System.out.println(true);
//        }
        if (Pattern.matches("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","<>")){

        }
        Pattern p = Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");
        Matcher m = p.matcher("<html>");
        String s = m.replaceAll("").trim();
        System.out.printf(s);
        if (Pattern.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+", "fasd@qq.com")) {
            System.out.println(true);
        }
        System.out.println("杨彭伟".length());
    }

    public static void test3() {
        SimpleDateFormat longFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sortFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        String dateStr = "2014-10-10";
        try {
            parse = longFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            try {
                parse = sortFormat.parse(dateStr);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        } finally {
            System.out.println(parse);
        }
    }

    public static void test4() {
        String [] ids = {"1","2","3","4"};
    }

    @Test
    public static void test5() {
        double x = 116.302821d;
        double y = 0.005d;
        System.out.println(x+y);


        BigDecimal x1 = new BigDecimal(x);
        BigDecimal y1 = new BigDecimal(y);
        System.out.println(x1.add(y1, MathContext.DECIMAL64));
        
        System.out.println(x1.subtract(y1,MathContext.DECIMAL64));
    }

    public static void main(String[] args) {
        test5();
    }
}
