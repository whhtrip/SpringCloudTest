/*
package com.interworking.mq.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

*/
/**
 * @author:WangHongHao
 * @date:19-10-14创建
 * @date：修改
 * @description：
 *//*

public class ActiveConnectionTest {
    public static String URL1 = ActiveMQConnection.DEFAULT_BROKER_URL;
    public static String URL = "tcp://192.168.179.131:61616";
    public static String USERNAME = "admin";
    public static String PASSWORD = "admin";
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,URL);//创建连接工厂
        Connection connection = activeMQConnectionFactory.createConnection();//创建连接
        connection.start();//开启连接
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建一个Session对象
        Queue queue = session.createQueue("test-queue");//&#x521b;&#x5efa;&#x4e00;&#x4e2a;ActiveMQ&#x63a5;&#x6536;&#x70b9;
        MessageProducer producer = session.createProducer(queue);//创建生产者并将目的地告诉它
        TextMessage hello_activeMQ = session.createTextMessage("hello ActiveMQ");//创建一个消息
        producer.send(hello_activeMQ);//生产者发送消息
        //关闭连接
        producer.close();
        session.close();
        connection.close();
    }
}
*/
