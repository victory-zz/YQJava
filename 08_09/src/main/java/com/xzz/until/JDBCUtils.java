package com.xzz.until;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
//  public static String url = "jdbc:mysql://localhost:3306/javatest";
//  public static String user = "root";
//  public static String password = "123456";
  private static Properties p=null;


  static {
    try {
      InputStream in = Thread.currentThread().getContextClassLoader().
          getResourceAsStream("db.properties");


      p = new Properties();
      p.load(in);

      Class.forName(p.getProperty("driver"));

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() throws SQLException {

    Connection connection = DriverManager.getConnection(
        p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
    return connection;
  }

  public static void close(Statement st, Connection conn) throws SQLException {
    if (st != null) {
      st.close();
    }
    if (conn != null) {
      conn.close();
    }
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

  public static void close(PreparedStatement pstm, Connection conn) throws SQLException {
    if (pstm != null) {
      pstm.close();
    }
    if (conn != null) {
      conn.close();
    }
  }

  public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) throws SQLException {
    if (rs != null) {
      rs.close();
    }
    if (pstm != null) {
      pstm.close();
    }
    if (conn != null) {
      conn.close();
    }
  }

}
