package com.xzz.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class demo5 {
  public static void main(String[] args) throws Exception {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(10);

    Class<? extends ArrayList> listClass = list.getClass();
    Method declaredMethod = listClass.getDeclaredMethod("add", Object.class);
    declaredMethod.invoke(list,"hello");
    declaredMethod.invoke(list,true);
    declaredMethod.invoke(list,10.10);
    System.out.println(list);
  }
}
