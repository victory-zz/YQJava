package com.xzz.reflection;

import com.xzz.domain.Student;
import com.xzz.domain.Worker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class demo4 {
  public static void main(String[] args) throws Exception {
    System.out.println("=========普通方式调用类中的方法=========");
    Worker worker = new Worker();
    worker.sayHello();

    Student student = new Student();
    student.sayHello();

    Properties p = new Properties();
    p.load(new FileReader("a.txt"));

    Class<?> myClassName = Class.forName(p.getProperty("myClassName"));
    Student instance = (Student) myClassName.newInstance();
    Method methodName = myClassName.getDeclaredMethod(p.getProperty("methodName"));
    methodName.invoke(instance,null);

    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入一个方法名：");
    String scMethodName = scanner.next();
    Method scDeMethod = myClassName.getDeclaredMethod(scMethodName);
    scDeMethod.invoke(instance,null);


  }
}
