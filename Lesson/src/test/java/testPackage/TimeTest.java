package testPackage;

import java.util.Date;

/**
 * @author:WangHongHao
 * @date:19-11-1创建
 * @date：修改
 * @description：
 */
public class TimeTest {
    public static void main(String[] args) {
        int sum = 0;
        Date date1 = new Date();
        for (int i = 0; i < 100000; i++) {
            sum++;
        }
        Date date2 = new Date();
        System.out.println(sum + " " + (date2.getTime()-date1.getTime()));
    }
}
