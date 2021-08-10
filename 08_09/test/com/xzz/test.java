package com.xzz;

import com.xzz.until.JDBCUtils;
import com.xzz.domain.User;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
  @Test
  public void findAllUser() throws SQLException {
    String sql="select * from user";
    PreparedStatement pstm = JDBCUtils.getConnection().prepareStatement(sql);
    ResultSet rs = pstm.executeQuery();
    while(rs.next()){
      System.out.println(rs.getString("userName"));
    }
  }

  @Test
  public void findOneUser() throws SQLException {
    String sql="select * from user where userName=?";
    PreparedStatement pstm = JDBCUtils.getConnection().prepareStatement(sql);
    pstm.setString(1,"xzz");
    ResultSet rs = pstm.executeQuery();
    User user = new User();
    while (rs.next()){
      user.setUserId(rs.getInt(1));
      user.setUserName(rs.getString(2));
      user.setPassword(rs.getString(3));
//      System.out.println("姓名："+rs.getString(2));
    }
    System.out.println(user);

  }
}
