package com.offcn.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {

	public Connection getConnection() {
		Connection conn = null;
		try {
			// 1.加载数据库驱动 反射機制
			Class.forName("com.mysql.jdbc.Driver");
			// 数据库url地址  協議+ip+端口+數據庫名？參數
			String url = "jdbc:mysql://localhost:3306/u_idleness_transaction_platform?useUnicode=true&characterEncoding=utf-8";
			// 数据库用户名
			String user = "root";
			// 数据库密码
			String password = "1234";
			// 2.创建数据库连接对象（代表：程序與數據庫之間的連接/橋樑）
			conn = DriverManager.getConnection(url, user, password);
			//3.語句對象（將程序中的sql語句發送到數據庫中）
		} catch (Exception e) {
			System.out.println("basedao 异常");
		}
		return conn;
	}
	
	public Statement getStmt(Connection conn) {
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	/**
	 * 此方法可以执行insert/delete/update 类型的sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql) {
		Connection conn = getConnection();
		Statement stmt = getStmt(conn);

		int i = -1;
		try {
			i = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				System.out.println("关流异常");
			}
		}
		return i;
	}

	public List<Map<String, Object>> executeQuery(String sql) {

		
		Connection conn = getConnection();
		Statement stmt = getStmt(conn);
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();

		ResultSet rs = null;
		ResultSetMetaData rsmt = null;
		try {
			rs = stmt.executeQuery(sql);
			rsmt = rs.getMetaData();
			
			//列数
			int count = rsmt.getColumnCount();
			
			while(rs.next()){
				Map<String,Object> map = new HashMap<String,Object>();
			
				for(int i = 1 ;i <= count ;i++ ){
					String key = rsmt.getColumnName(i);
					Object val = rs.getObject(key);
					
					map.put(key, val);
				}
				
				list.add(map);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		/*String sql = "DELETE  FROM favorites WHERE id = 2";
		int i = new BaseDao().executeUpdate(sql);
		System.out.println(i);*/
		
		String sql = "SELECT * FROM u_idle_user";
		 List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		 System.out.println(list);
	}
}
