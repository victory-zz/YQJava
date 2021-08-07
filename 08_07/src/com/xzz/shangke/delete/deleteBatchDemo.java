package com.xzz.shangke.delete;

import com.xzz.until.JDBCUntil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteBatchDemo {
  private static Scanner sc=new Scanner(System.in);
  private static Connection conn=null;
  private static PreparedStatement pstm=null;
  private static ResultSet rs=null;

  public static void main(String[] args) throws SQLException {
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
   * 批量删除数据
   */
  public static int deleteBatch(int[] id) throws SQLException {
    conn= JDBCUntil.getConn();
    int sum=0;
    String sql="delete from user where userId=?";
    pstm = conn.prepareStatement(sql);
    for (int i=0;i< id.length;i++){
      pstm.setInt(1,id[i]);
      pstm.executeUpdate();
      if (pstm.executeUpdate()>0){
        sum+=1;
      }
    }
    return sum;
  }
}
