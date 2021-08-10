package com.xzz.annotation;

import java.lang.reflect.Method;

public class MyAnTest {
  public static void main(String[] args) throws Exception {
    //1.获取字节码文件
    Class<AnalyzeAnnotations> analyzeAnnotationsClass = AnalyzeAnnotations.class;
    //2.获取所有的方法
    Method[] declaredMethods = analyzeAnnotationsClass.getDeclaredMethods();

    for (Method m: declaredMethods) {
    //3.判断所有方法中那些使用了自定义的注解
      boolean b = m.isAnnotationPresent(MyTest.class);
      if (b){
        m.invoke(analyzeAnnotationsClass.newInstance(),null);
      }
    }


  }
}
