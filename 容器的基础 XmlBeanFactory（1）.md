## 容器的基础 XmlBeanFactory（1）
> 这是第一篇Spring源码分析，主要是为了找到继续阅读源码的兴趣，了解一个概况同时找了`ignoreDependencyInterface`和`ignoreDependencyType`深入分析了下。

### 参考链接
1. [打开BeanFactory ignoreDependencyInterface方法的正确姿势](https://www.jianshu.com/p/3c7e0608ff1f)
2. [BeanFactoryPostProcessor详解 - 愤怒的苹果ext的博客](https://blog.csdn.net/baidu_19473529/article/details/81152109)

### 概况
1. 我们通过一个简单例子切入源码，阅读*spring-bean-test1*，简单了解获取一个`bean`的过程
2. 首先介绍了核心类`DefaultListableBeanFactory`，其次按照在该类注释中@see顺序大致了解下各个类
3. 进入到`XmlBeanFactory`了解`XmlBeanFactory`和`DefaultListableBeanFactory`的区别，了解构造过程
4. 进入到`AbstractAutowireCapableBeanFactory`的构造函数，进而深入到`ignoreDependencyInterface`中查看其作用，以及与`ignoreDependencyType`区别
5. 最后通过小例子*ignored-dependency-test*来查看`ignoreDependencyType`以及`ignoreDependencyInterface`是如何工作的在自动装配的过程中忽略某些类

### 总结
1. `BeanFactoryPostProcessor`是`Spring`提供的一个扩展点，让我们可以在所有`bean`都加载、注册完成（还未初始化）的时候，允许我们做一些修改，例子中我们可以在自动注入的时候忽略某些属性的注入，或者修改成员属性的值
2. `ignoreDependencyType`以及`ignoreDependencyInterface`两者是不同的，平时`ignoreDependencyType`的功能已经足够使用，而`ignoreDependencyInterface`是忽略接口中的`set`方法，从而在实现类中具有相同参数的`set`方法也会被忽略，从而对应的成员在自动装配的时候被忽略，目的是为了某些重要的成员属性（比如`ApplicationContextAware`、`BeanFactoryAware`）统一交由框架进行注入。