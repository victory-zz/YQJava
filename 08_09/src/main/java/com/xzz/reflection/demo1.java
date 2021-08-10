package com.xzz.reflection;

import com.xzz.domain.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class demo1 {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    //1.第一种
  //   Class<User> forName = (Class<User>) Class.forName("com.xzz.domain.User");
  //   Constructor<?>[] constructors =  forName.getConstructors();
  //   for (Constructor<?> c: constructors) {
  //     System.out.println(c);
  //   }
  //
  //   // System.out.println(forName);
  //
  // //  2.第二种
  //   User user = new User();
  //   Class<? extends User> aClass = user.getClass();
  //   Constructor<? extends User> conTwo = aClass.getConstructor();

    // System.out.println(aClass);

  //  3.直接通过某个类来调用class属性
    Class<User> userClass = User.class;
    //包括私有的
    Constructor<User> userClassConstructor = userClass.getDeclaredConstructor(String.class,String.class);
    System.out.println(userClassConstructor);

    userClassConstructor.setAccessible(true);

    //通过反射取出创建出来的实例，和 通过普通方式创建的不一样
    User newInstance = userClassConstructor.newInstance("xzzz","123456");
    System.out.println(newInstance);

  }
}
