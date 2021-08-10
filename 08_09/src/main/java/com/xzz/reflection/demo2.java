package com.xzz.reflection;

import com.xzz.domain.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class demo2 {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<?> user = Class.forName("com.xzz.domain.User");

  //  获取成员属性,拿到的是所有公共修饰符的属性
    System.out.println("============获取所有public的属性=============");
    Field[] fields = user.getFields();
    for (Object o: fields) {
      System.out.println(o);
    }

    System.out.println("============获取所有包括私有的属性=============");
    Field[] declaredFields = user.getDeclaredFields();
    for (Object o: declaredFields) {
      System.out.println(o);
    }

    System.out.println("===============获取某一个指定的成员属性(公有地)===============");
    Field sex = user.getField("sex");
    System.out.println(sex);

    System.out.println("===============获取某一个指定的成员属性(所有的，包括私有的)===============");
    Field userDeclaredFieldSex = user.getDeclaredField("sex");
    Field userDeclaredFieldName = user.getDeclaredField("userName");
    System.out.println(userDeclaredFieldSex);
    System.out.println(userDeclaredFieldName);

    System.out.println("================设置属性值=================");
    Constructor<?> userDeclaredConstructor = user.getDeclaredConstructor(String.class, String.class);
    userDeclaredConstructor.setAccessible(true);
    Object o = userDeclaredConstructor.newInstance("xzzzzz", "123456");
    userDeclaredFieldName.setAccessible(true);
    userDeclaredFieldName.set(o,"crrrrr");
    System.out.println(o);
  }
}
