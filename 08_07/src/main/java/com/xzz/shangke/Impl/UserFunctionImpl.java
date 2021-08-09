package com.xzz.shangke.Impl;



import com.xzz.shangke.User;
import com.xzz.until.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFunctionImpl implements UserFunction {
    /**
     * 查询所有用户信息
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> findAllUser() throws SQLException {
        ResultSet resultSet = null;

        String sql = "select * from user";

        resultSet = JDBCUtils.select(sql);
        List<User> userList = new ArrayList<User>();
        while (resultSet.next()) {
            User user = new User();
            user.setUserId(resultSet.getInt("userId"));
            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
            userList.add(user);
        }

        return userList;
    }

    /**
     * 根据用户名和密码去查询某个用户
     * @param uname
     * @param pwd
     * @return
     * @throws SQLException
     */
    @Override
    public User findUser(String uname, String pwd) throws SQLException {
        ResultSet resultSet = null;
        User user = new User();
        String sql = "select * from user where userName = '" + uname + "' and password = '" + pwd + "'";
        resultSet = JDBCUtils.select(sql);
        while (resultSet.next()) {

            user.setUserId(resultSet.getInt("userId"));
            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
        }
        return user;
    }

    /**
     * 根据用户的id去查询某个用户
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public User findUserId(int id) throws SQLException {
        ResultSet resultSet = null;
        User user = new User();
        String sql = "select * from user where userId =" + id;

        resultSet = JDBCUtils.select(sql);
        while (resultSet.next()) {

            user.setUserId(resultSet.getInt("userId"));
            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
        }
        return user;
    }

    /**
     * 登录功能
     * @param uname
     * @param pwd
     * @throws SQLException
     */
    @Override
    public void userLogin(String uname, String pwd) throws SQLException {
        ResultSet resultSet = null;
        User user = new User();
        String sql = "select * from user where userName = '" + uname + "' and password = '" + pwd + "'";

        resultSet = JDBCUtils.select(sql);
        while (resultSet.next()) {

            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
        }
        if (user.getPassword() != null && user.getUserName() != null) {
            System.out.println("你好" + user.getUserName() + "登录成功");

        } else {
            System.out.println("登录失败");

        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteUser(int id) throws SQLException {
        String sql = "delete from user where userId = "+ id;
        int flag = JDBCUtils.update(sql);
        return flag;
    }

    @Override
    public int insertUser(User user) throws SQLException {
        String sql = "INSERT INTO user(userName,password) VALUES("+user.getUserName()+","+user.getPassword()+")";
        int flag = JDBCUtils.update(sql);
        return flag;
    }



    @Override
    public int deleteUserByIds(int[] ids) throws Exception {
        int  i = 0;
        for (int id : ids) {
           UserFunction uf = new UserFunctionImpl();
           int count =  uf.deleteUser(id);
            i=i+count;
        }

        return i;
    }
}
