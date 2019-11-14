package testPackage;

import com.alibaba.fastjson.JSONObject;
import com.lesson.mybatisTest.domain.User;

/**
 * @author:WangHongHao
 * @date:19-11-1创建
 * @date：修改
 * @description：
 */
public class JsonTest {
    public static void main(String[] args) {
        System.out.println("Hello");
        User user = JSONObject.parseObject("{\"userId\":2,\"username\":\"whh\",\"userBirthday\":null,\"createTime\":null}", User.class);
        System.out.println(user.getUsername());
    }
}
