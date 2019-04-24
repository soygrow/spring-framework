package com.spring.test1;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by zhanghao on 2019-04-20.
 */
public class ResourceTest {

    /**
     * 简单了解Resource这个类
     * @param args
     */
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("beanFactoryTest.xml");

        try {
            System.out.println("resource: " + resource.contentLength());
            System.out.println("resource: " + resource.lastModified());
        } catch (IOException e) {

        }

    }
}
