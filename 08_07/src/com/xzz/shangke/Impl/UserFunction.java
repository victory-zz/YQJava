package com.xzz.shangke.Impl;



import com.xzz.shangke.User;

import java.sql.SQLException;
import java.util.List;

public interface UserFunction {
    List<User> findAllUser() throws SQLException;

    User findUser(String uname,String pwd) throws SQLException;

    User findUserId(int id) throws SQLException;

    void userLogin(String uname,String pwd) throws SQLException;

    int deleteUser(int id) throws SQLException;

    int insertUser(User user ) throws SQLException;



    int deleteUserByIds(int[]ids)throws Exception;




}
