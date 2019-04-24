package com.spring.test1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zhanghao on 2019-04-17.
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        BeanD beanD = (BeanD) bf.getBean("beanD");

        System.out.println("beanD -> " + beanD.getTestStr());
    }
}
