package com.spring.ignored.test;

/**
 * Created by zhanghao on 2019-04-23.
 */
public class IgnoredInterfaceImpl implements IgnoredInterface {

    private InterfaceObject interfaceObject;

    public void setInterfaceObject(InterfaceObject interfaceObject) {
        this.interfaceObject = interfaceObject;
    }

    public void testInterface() {
        System.out.println(interfaceObject == null ? "interfaceObject is null" : interfaceObject.info());
    }
}
