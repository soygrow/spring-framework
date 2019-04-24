package com.spring.ignored.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by zhanghao on 2019-04-23.
 */
public class IgnoredAutowiringProcessor implements BeanFactoryPostProcessor {

    /**
     * 这里和BeanPostProcessor类似，提供了一个扩展点
     * 当容器初始化之后，Spring负责调用postProcessBeanFactory方法
     * 这里是提供给子类的扩展点，到这里的时候，所有的 Bean 都加载、注册完成了，但是都还没有初始化
     * 具体的子类可以在这步的时候根据业务添加或修改一些特殊的 beanFactory属性
     *
     * 注意：ignoreDependencyInterface并不是在自动装配的时候忽略某些接口的实现，而是忽略在接口实现
     * 中和接口set方法相同参数的注入，一般是为了后面框架统一注入。
     *
     * @param beanFactory
     * @throws BeansException
     */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        beanFactory.ignoreDependencyInterface(IgnoredInterface.class);
        //beanFactory.ignoreDependencyType(IgnoredInterface.class);

        // 根据业务需求可以动态修改BeanFactory的属性，如果上面忽略了类的自动注入，那么下面代码执行会出错
        //BeanDefinition beanDefinition = beanFactory.getBeanDefinition("interfaceObject");
        //beanDefinition.getPropertyValues().add("age", "19");
    }
}
