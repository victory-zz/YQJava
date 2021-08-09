package com.xzz.homeword;

import com.xzz.shangke.Impl.UserFunction;
import com.xzz.shangke.Impl.UserFunctionImpl;
import com.xzz.shangke.User;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class sqldemo {
  UserFunction uf = new UserFunctionImpl();
  @Test
  public void getUser() throws SQLException {

    List<User> userList = uf.findAllUser();
    System.out.println("=============所有的用户信息==========");
    for (User user : userList) {
      System.out.println(user);
    }
  }

  @Test
  public void getOneUser() throws SQLException {
    User user = uf.findUser("xzz", "12345678");
    System.out.println(user);
  }

  @Test
  public void getOneUserOfId() throws SQLException {
    User user = uf.findUserId(17);
    if (user.getUserName()!=null && user.getPassword()!=null){
      System.out.println(user);
    }else {
      System.out.println("未找到该用户");
    }
  }

  @Test
  public void deleteOne() throws SQLException {
    int i =uf.deleteUser(18);
    if(i>0){
      System.out.println("删除成功");
    }else{
      System.out.println("删除失败");
    }
  }


}
