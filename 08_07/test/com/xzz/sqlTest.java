package com.xzz;

import com.xzz.until.JDBCUntil;
import org.junit.Test;

import java.sql.*;

public class sqlTest {
  Connection conn=null;
  Statement statement=null;
  ResultSet resultSet=null;
  PreparedStatement preparedStatement=null;

  @Test
  public void findUser(){
    try {
      conn= JDBCUntil.getConn();
      statement = conn.createStatement();
      String sql="select * from user";
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()){
        System.out.println("姓名："+resultSet.getString("userName"));
        System.out.println("密码："+resultSet.getString("password"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      JDBCUntil.close(resultSet,statement,conn);
    }
  }

  @Test
  public void insertUser(){
    try {
      conn=JDBCUntil.getConn();
      Statement statement = conn.createStatement();
      String sql="insert into user(userName,password) values('zhangsan','123')";
      int i = statement.executeUpdate(sql);
      System.out.println("插入成功，已更新表中的"+i+"行");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally {
      JDBCUntil.close(statement,conn);
    }
  }

  @Test
  public void updateUser(){
    try {
      conn=JDBCUntil.getConn();
      Statement statement = conn.createStatement();
      String sql="update user set password='12345678' where userName='xzz'";
      int i = statement.executeUpdate(sql);
      System.out.println("更新表成功，已更新表中的"+i+"行");
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      JDBCUntil.close(statement,conn);
    }
  }

  @Test
  public void deleteUser(){
    try {
      conn=JDBCUntil.getConn();
      Statement statement = conn.createStatement();
      String sql="delete from user where userName='zhangsan'";
      int i = statement.executeUpdate(sql);
      if (i > 0) {
        System.out.println("更新表成功，已更新表中的"+i+"行");
      }
      System.out.println("删除失败，您要删除的数据不在该数据表中。");
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      JDBCUntil.close(statement,conn);
    }
  }

  @Test
  public void findUserOfPrepareStatement(){
    try {
      conn=JDBCUntil.getConn();
      String sql="select * from user where userName=?";
      preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1,"xzz");
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        System.out.println("姓名："+resultSet.getString("userName"));
        System.out.println("密码："+resultSet.getString("password"));
      }

    } catch (SQLException e) {
      System.out.println("您的sql语句有误，出错信息为："+e.getMessage());
    }finally {
      JDBCUntil.close(resultSet,preparedStatement,conn);
    }
  }

  @Test
  public void insertUserOfPrepareStatement(){
    try {
      conn=JDBCUntil.getConn();
      String sql="insert into user(userName, password) values(?,?)";
      preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1,"zhangsan");
      preparedStatement.setString(2,"11111111");
      int i = preparedStatement.executeUpdate();
      if (i>0){
        System.out.println("更新成功");
      }else {
        System.out.println("更新失败");
      }

    } catch (SQLException e) {
      System.out.println("您的sql语句有误，出错信息为："+e.getMessage());
    }finally {
      JDBCUntil.close(preparedStatement,conn);
    }
  }




}
