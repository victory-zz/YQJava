package com.xzz.until;

import java.sql.*;

public class JDBCUntil {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/javatest?serverTimezone=UTC";
	private static final String username="root";
	private static final String password="123456";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static void close(Statement st,Connection connection){
		if (st!=null){
			try {
				st.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (connection!=null){
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstm,Connection connection){
		if (pstm!=null){
			try {
				pstm.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (connection!=null){
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs,Statement st,Connection connection){
		if (rs!=null){
			try {
				rs.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (st!=null){
			try {
				st.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (connection!=null){
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

	}
	public static void close(ResultSet rs,PreparedStatement pstm,Connection connection) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

	}
}
