package com.xzz;

import com.xzz.until.JDBCUntil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteTest {
  private static Scanner sc=new Scanner(System.in);
  private static Connection conn=null;
  private static PreparedStatement pstm=null;
  private static ResultSet rs=null;

  @Test
  public void deleteOneDemo() throws SQLException {
    System.out.print("请输入你要删除的用户名：");
    String deleteUserName = sc.next();
    int i = deleteOne(deleteUserName);
    if (i>0){
      System.out.println("删除成功！");
    }else {
      System.out.println("删除失败！");
    }
  }

  @Test
  public void deleteBatchDemo() throws SQLException {
    System.out.print("请输入你要删除的个数：");
    int deleteNum = sc.nextInt();
    int[] deleteId=new int[deleteNum];
    for (int i=0;i<deleteId.length;i++){
      deleteId[i]=sc.nextInt();
    }
    int deleteBatch = deleteBatch(deleteId);
    if (deleteBatch>0){
      System.out.println("已成功删除"+deleteBatch+"个用户的信息");
    }else {
      System.out.println("批量删除失败！");
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

  /**
   * 批量删除数据
   */
  public int deleteBatch(int[] id) throws SQLException {
    conn=JDBCUntil.getConn();
    int sum=0;
    String sql="delete from user where userId=?";
    for (int i=0;i< id.length;i++){
      pstm.setInt(1,id[i]);
      pstm = conn.prepareStatement(sql);
      if (pstm.executeUpdate()>0){
        sum+=1;
      }
    }
    return sum;
  }

}
