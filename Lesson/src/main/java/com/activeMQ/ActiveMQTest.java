/*
package com.activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

*/
/**
 * @author:WangHongHao
 * @date:19-10-15创建
 * @date：修改
 * @description：
 *//*

public class ActiveMQTest {
    public static String URL = "tcp://192.168.179.131:61616";
    public static String USERNAME = "admin";
    public static String PASSWORD = "admin";
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("test-queue");
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        String text = textMessage.getText();
                        System.out.println(text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
*/
