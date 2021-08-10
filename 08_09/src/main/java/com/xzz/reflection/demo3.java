package com.xzz.reflection;

import com.xzz.domain.Fun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class demo3 {
  public static void main(String[] args) throws Exception {
    Class<?> aClass = Class.forName("com.xzz.domain.Fun");

    System.out.println("==============获取它父类和它自己的所有 public 方法=============");
    Method[] methods = aClass.getMethods();
    for (Object o: methods) {
      System.out.println(o);
    }

    System.out.println("==============获取所有的方法，包括非public=============");
    Method[] dMethods = aClass.getDeclaredMethods();
    for (Object o: dMethods) {
      System.out.println(o);
    }

    System.out.println("==============获取单个public方法=============");
    Method oneMethod = aClass.getMethod("show");
    System.out.println(oneMethod);
    Constructor<?> constructor = aClass.getDeclaredConstructor();
    Fun funInstance = (Fun) constructor.newInstance();
    oneMethod.invoke(funInstance);

    System.out.println("==============获取单个私有方法=============");
    Method priShowMethod = aClass.getDeclaredMethod("priShow");
    System.out.println(priShowMethod);
    priShowMethod.setAccessible(true);
    priShowMethod.invoke(funInstance,null);

  }
}
