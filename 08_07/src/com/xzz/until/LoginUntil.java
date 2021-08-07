package com.xzz.until;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginUntil {
  private static Scanner sc=new Scanner(System.in);
  private static Connection conn=null;
  private static PreparedStatement pstm=null;
  private static ResultSet rs=null;
  public static void getLogin(){
    boolean isLogin=true;
    try {
      do {
        System.out.print("用户名：");
        String username = sc.next();
        System.out.print("密码：");
        String password = sc.next();
        conn = JDBCUntil.getConn();
        String sql="SELECT * from user where userName=? and password=?";
        pstm = conn.prepareStatement(sql);
        pstm.setString(1,username);
        pstm.setString(2,password);
        rs = pstm.executeQuery();
        if (rs.next()){
          System.out.println("登录成功！");
          isLogin=false;
        }
        System.out.println();
      }while (isLogin);
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      JDBCUntil.close(rs,pstm,conn);
    }
  }
}
