package com.spring.ignored.test;

/**
 * Created by zhanghao on 2019-04-23.
 */
public class InterfaceObjectImpl implements InterfaceObject {
    private String name;
    private Integer age;

    public InterfaceObjectImpl(String name, Integer age) {
        this.name = name;
        this.age = age;

        System.out.println("name: " + name + " age: " + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String info() {
        return name + " " + age;
    }
}
