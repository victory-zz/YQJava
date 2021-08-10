package com.xzz.annotation;

import org.junit.Test;

public class AnalyzeAnnotations {

  @Test
  public void fun1(){
    System.out.println("我是Test注解");
  }

  @MyTest
  public void fun2(){
    System.out.println("我是自定义注解，fun2");
  }

  @MyTest
  public void fun3(){
    System.out.println("我是自定义注解，fun3");
  }

  @MyTest
  public void fun4(){
    System.out.println("我是自定义注解，fun4");
  }



  public void fun5(){
    System.out.println("我是普通方法，fun5");
  }

}
