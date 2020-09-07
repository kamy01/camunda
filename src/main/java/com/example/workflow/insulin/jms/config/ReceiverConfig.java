package com.example.workflow.insulin.jms.config;

import com.example.workflow.insulin.jms.TransactionListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

@Configuration
public class ReceiverConfig {
    private Connection connection;

    private Session session;

    @Bean
    public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory;
        String brokerUrl = "localhost:61616";
//        activeMQConnectionFactory.setBrokerURL(brokerUrl);
//        activeMQConnectionFactory.setUserName("cgmuser");
//        activeMQConnectionFactory.setPassword("cgmpassword1!");


        activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setUserName("cgmuser");
        activeMQConnectionFactory.setPassword("cgmpassword1!");

        activeMQConnectionFactory.setBrokerURL( "tcp://127.0.0.1:61616");
        return activeMQConnectionFactory;
    }
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws JMSException {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory
                .setConnectionFactory(receiverActiveMQConnectionFactory());
        factory.setConcurrency("3-10");

        return factory;
    }

    @Bean
    public TransactionListener receiver() {
        return new TransactionListener();
    }
}
