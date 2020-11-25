package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	//DB연결후 연결정보(Connection 객체)를 리턴해 주는 메소드
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds= (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
			conn=ds.getConnection();
			conn.setAutoCommit(false);
			System.out.println("db연결 정상");
		} catch (Exception e) {
			System.out.println("오류!! db연결 비정상");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
				System.out.println("Connection 반납완료");
			} catch (SQLException e) {
				System.out.println("오류!! Connection 반납오류");
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
				System.out.println("Statement반납완료");
			} catch (SQLException e) {
				System.out.println("오류!! Statement 반납오류");
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
				System.out.println("ResultSet 반납완료");
			} catch (SQLException e) {
				System.out.println("오류!! ResultSet 반납오류");
				e.printStackTrace();
			}
		}
	}
	
	public static void commit(Connection conn) {
		if(conn!=null) {
			try {
				conn.commit();
				System.out.println("커밋완료");
			} catch (SQLException e) {
				System.out.println("오류!! 커밋실패");
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if(conn!=null) {
			try {
				conn.rollback();
				System.out.println("롤백완료");
			} catch (SQLException e) {
				System.out.println("오류!! 롤백실패");
				e.printStackTrace();
			}
		}
	}
	
	
}



