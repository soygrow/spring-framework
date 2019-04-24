package com.spring.ignored.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zhanghao on 2019-04-23.
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 参考链接：https://www.jianshu.com/p/3c7e0608ff1f
         *          https://blog.csdn.net/baidu_19473529/article/details/81152109
         *
         * 刚开始用XmlBeanFactory作为BeanFactory的时候，发现并不会处理BeanFactoryPostProcessor
         * 这里主要是因为XmlBeanFactory没有实现AbstractApplicationContext接口
         *
         * 这里我花了比较长时间去查找什么原因，这里处理的逻辑是ignoreDependencyInterface和ignoreDependencyType
         * 是在哪里执行的-->postProcessBeanFactory在哪里执行的-->BeanFactoryPostProcessor接口实现在何时被调用，
         * 这里可以继续查找，可以看到AbstractApplicationContext中refresh方法
         * @see org.springframework.context.support.AbstractApplicationContext
         *
         * 查看invokeBeanFactoryPostProcessors方法，最终走到invokeBeanFactoryPostProcessors这里，但是
         * XmlBeanFactory没有执行BeanFactoryPostProcessors，这个我们调试下断点就可以发现。
         *
         * 扩展：如果我们实现了BeanPostProcessor扩展点，同时我们还需要实现ImportBeanDefinitionRegistrar去注册
         * BeanDefinition，从而才能扩展Bean的后置处理器。
         */
        //BeanFactory bf = new XmlBeanFactory(new ClassPathResource("ignored-interface.xml"));
        //IgnoredInterfaceImpl ignoredInterfaceImpl = (IgnoredInterfaceImpl) bf.getBean("ignoredInterface");
        //ignoredInterfaceImpl.testInterface();

        ClassPathXmlApplicationContext cxAc = new ClassPathXmlApplicationContext("ignored-interface.xml");
        IgnoredInterfaceImpl ignoredInterfaceImpl = (IgnoredInterfaceImpl) cxAc.getBean("ignoredInterface");
        ignoredInterfaceImpl.testInterface();
    }
}
