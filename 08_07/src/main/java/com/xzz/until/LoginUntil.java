package com.xzz.until;

import com.xzz.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginUntil {
  private static Scanner sc=new Scanner(System.in);
  private static Connection conn=null;
  private static PreparedStatement pstm=null;
  private static ResultSet rs=null;


  /**
   * 1.注册功能
   */
  public static int registerUser(){
    int i=0;
    try {
      do {
        System.out.print("用户名：");
        String username = sc.next();
        System.out.print("密码：");
        String firstPassword = sc.next();
        System.out.print("再输一次密码：");
        String secondPassword = sc.next();
        if (!firstPassword.equals(secondPassword)){
          System.out.println("您输入的两次密码不一致，请重新输入！");
          continue;
        }
        i = register(username,secondPassword);
      }while (i<1);
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      JDBCUntil.close(rs,pstm,conn);
    }
    return i;
  }


  /**
   * 2.登录功能
   */
  public static void getLogin(){
    boolean isLogin=true;
    try {
      do {
        System.out.print("用户名：");
        String username = sc.next();
        System.out.print("密码：");
        String password = sc.next();
        User user = findUser(username, password);
        if (user.getUserName()!=null && user.getPassword()!=null){
          System.out.println("欢迎 "+ user.getUserName() + " 登陆成功");
          isLogin=false;
        }else {
          System.out.println("您输入的账号或者密码错误，请重新输入！");
        }
      }while (isLogin);
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      JDBCUntil.close(rs,pstm,conn);
    }
  }

  /**
   * 3.修改密码
   * @return
   */
  public static int updateUserPassword() throws SQLException {
    int i=0;
    do {
      System.out.print("请输入用户名：");
      String username = sc.next();
      System.out.print("请输入您正在使用的密码：");
      String pwd = sc.next();
      User user = findUser(username, pwd);
      if (user.getUserName()!=null){
        System.out.print("请输入新密码：");
        String newFirstPassword = sc.next();
        System.out.print("请再输一次新密码：");
        String newSecondPassword = sc.next();
        if (!newFirstPassword.equals(newSecondPassword)){
          System.out.println("两次密码输入不一致，请重新输入！");
          continue;
        }
         i= updatePassword(username,newFirstPassword);
      }else {
        System.out.println("您输入的账号密码错误，请重新输入验证成功后再进行修改。");
      }
    }while (i<0);
    return i;
  }

  public static int updatePassword(String name,String pwd) throws SQLException {
    conn=JDBCUntil.getConn();
    String sql="update user set password=? where userName=?";
    pstm = conn.prepareStatement(sql);
    pstm.setString(1,pwd);
    pstm.setString(2,name);
    return pstm.executeUpdate();
  }


  public static int register(String username,String password) throws SQLException {
    conn = JDBCUntil.getConn();
    String sql="insert into user(userName, password) values(?,?)";
    pstm = conn.prepareStatement(sql);
    pstm.setString(1,username);
    pstm.setString(2,password);
    return pstm.executeUpdate();
  }

  public static User findUser(String username,String password) throws SQLException {
    conn = JDBCUntil.getConn();
    String sql="SELECT * from user where userName=? and password=?";
    pstm = conn.prepareStatement(sql);
    pstm.setString(1,username);
    pstm.setString(2,password);
    rs = pstm.executeQuery();
    User user = new User();
    while (rs.next()){
      user.setUserName(rs.getString("userName"));
      user.setPassword(rs.getString("password"));
    }
    return user;
  }
}
