package com.xzz.shangke.delete;

import com.xzz.until.JDBCUntil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteOneDemo {
  private static Scanner sc=new Scanner(System.in);
  private static Connection conn=null;
  private static PreparedStatement pstm=null;
  private static ResultSet rs=null;

  public static void main(String[] args) throws SQLException {
    System.out.print("请输入你要删除的用户名：");
    String deleteUserName = sc.next();
    int i = deleteOne(deleteUserName);
    if (i>0){
      System.out.println("删除成功！");
    }else {
      System.out.println("删除失败！");
    }
  }

  /**
   * 单条数据删除
   * @param name
   * @return
   */
  public static int deleteOne(String name) throws SQLException {
    conn= JDBCUntil.getConn();
    String sql="delete from user where userName=?";
    pstm = conn.prepareStatement(sql);
    pstm.setString(1,name);
    return pstm.executeUpdate();
  }
}
