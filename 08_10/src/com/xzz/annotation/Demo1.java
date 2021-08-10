package com.xzz.annotation;

@MyAnnotation(value = "哈哈")
public class Demo1 {

  @MyAnnotation(value = "xzz")
  public String name;

  @MyAnnotation("22")
  public Integer age;

  @MyAnnotation
  public String a;

  public static void main(String[] args) {
    Demo1 demo1 = new Demo1();
    System.out.println(demo1.name);
  }


  // @MyAnnotation(value = "dd")
  // private void aa(){
  //
  // }
}
