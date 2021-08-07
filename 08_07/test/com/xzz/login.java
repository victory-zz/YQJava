package com.xzz;

import com.xzz.domain.User;
import com.xzz.until.JDBCUntil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class login {
  private static Connection conn=null;
  private static PreparedStatement preparedStatement=null;
  private static ResultSet resultSet=null;

  public static void main(String[] args) throws SQLException {
    List<User> users = findUser();
    for (User user : users) {
      System.out.println(user);
    }
  }

  public static List<User> findUser() throws SQLException {
    conn = JDBCUntil.getConn();
    String sql="select * from user";
    preparedStatement = conn.prepareStatement(sql);
    resultSet= preparedStatement.executeQuery();
    User user = new User();
    List<User> userList=new ArrayList<User>();
    while (resultSet.next()){
      user.setUserId(resultSet.getInt("userId"));
      user.setUserName(resultSet.getString("userName"));
      user.setPassword(resultSet.getString("password"));
      userList.add(user);
    }
    return userList;
  }

}
