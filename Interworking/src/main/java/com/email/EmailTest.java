package com.email;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class EmailTest {

    public static final String ADD_URL = "http://10.100.252.206:5050";

    public static void appadd() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String title = "标题";
            String content = "E学习批处理失败邮件：<br>\n" +
                    "\t&nbsp;&nbsp;&nbsp;&nbsp;邮件id：<br>\n" + currentTimeMillis +
                    "\t&nbsp;&nbsp;&nbsp;&nbsp;批处理描述：<br>\n" +
                    "\t&nbsp;&nbsp;&nbsp;&nbsp;失败原因：<br>\n" +
                    "\t&nbsp;&nbsp;&nbsp;&nbsp;失败交接时间：<br>";
            String titleBase = Base64.getEncoder().encodeToString(title.getBytes());
            String contentBase = Base64.getEncoder().encodeToString(content.getBytes());
            //创建连接
            URL url = new URL(ADD_URL);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.connect();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //Date date = new Date(new Date().getTime()+5000);
            Date date = new Date();
            String format = simpleDateFormat.format(date);
            //POST请求
            DataOutputStream out = new DataOutputStream(
                    connection.getOutputStream());
            JSONObject obj = new JSONObject();
            String aaa = "dsadsadads";
            obj.put("id", "egrowth" + currentTimeMillis);//邮件流水号,不能重复
            obj.put("from_address", "95509@ehuatai.com");//发邮箱
            //obj.put("from_address", "18252587517@163.com");//发邮箱
            //obj.put("to_address", "18252587517@163.com");//收邮箱
            obj.put("to_address", "wanghonghao@sinosoft.com.cn");//收邮箱
            //obj.put("file_name", "001");//附件名称
            //obj.put("file_path", "asd");//附件地址
            obj.put("subject", titleBase);//标题
            obj.put("content", contentBase);//内容
            obj.put("policy_code", "1");//保单号
            obj.put("send_type", "sendcloud");//邮件发送方式
            obj.put("send_time", format);//邮件发送时间
            obj.put("channel", "E学习");//发送方
            System.out.println(obj.toString());
            out.writeBytes(obj.toString());
            out.flush();
            out.close();

            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmailTest addTest = new EmailTest();
        addTest.appadd();
       /* Map<Object, Object> map = new HashMap<>();
        dealMap(map);
        System.out.println(map);*/
        //exceptionTest();
        //UUID uuid = UUID.randomUUID();
        //System.out.println(uuid);
        //long l = System.currentTimeMillis();
        //System.out.println(l);
        //md5();
    }

    public static void dealMap(Map map) {
        map.put("1", "1");
    }

    public static void exceptionTest() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println("e.getMessage" + e.getMessage());
            System.out.println("e.toString" + e.toString());
            System.out.println("e.getCause" + e.getCause());
            System.out.println(e.getLocalizedMessage());
            //System.out.println(e.getStackTrace());
        }
    }

    public static void md5() {
        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        String str = "sdfdsfsdfsdfsdfszffdsf";
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            //return new BigInteger(1, md.digest()).toString(16);
            String s1 = new BigInteger(1, md.digest()).toString(32);
            System.out.println(s1);
            byte[] digest = md.digest();
            for (int i = 0; i < digest.length; i++) {
                System.out.println(digest[i]);
            }
            String s = new String(digest);
            System.out.println(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 计算md5函数
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        String s = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println(s);
        String uuidString = UUID.randomUUID().toString();
        System.out.println(uuidString);
        int uuid = uuidString.hashCode();
        if (uuid<0){
            uuid = -uuid;
        }
        System.out.println(uuid);
        String format = String.format("%015d", uuid);
        System.out.println(format);

        long l = System.currentTimeMillis();
        int i =0;
        long l1 = System.currentTimeMillis();
        System.out.println(l1 == l);
    }
}