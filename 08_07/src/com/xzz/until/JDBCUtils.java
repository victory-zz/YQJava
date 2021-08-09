package com.xzz.until;

import java.sql.*;


public class JDBCUtils {
    public static String url = "jdbc:mysql://localhost:3306/javatest";
    public static String user = "root";
    public static String password = "123456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void close(ResultSet rs, Statement st, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public static ResultSet select(String sql) throws SQLException {
        Connection connection =JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public static int update(String sql) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }


}
