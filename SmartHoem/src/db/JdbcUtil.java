package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	//DB������ ��������(Connection ��ü)�� ������ �ִ� �޼ҵ�
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds= (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
			conn=ds.getConnection();
			conn.setAutoCommit(false);
			System.out.println("db���� ����");
		} catch (Exception e) {
			System.out.println("����!! db���� ������");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
				System.out.println("Connection �ݳ��Ϸ�");
			} catch (SQLException e) {
				System.out.println("����!! Connection �ݳ�����");
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
				System.out.println("Statement�ݳ��Ϸ�");
			} catch (SQLException e) {
				System.out.println("����!! Statement �ݳ�����");
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
				System.out.println("ResultSet �ݳ��Ϸ�");
			} catch (SQLException e) {
				System.out.println("����!! ResultSet �ݳ�����");
				e.printStackTrace();
			}
		}
	}
	
	public static void commit(Connection conn) {
		if(conn!=null) {
			try {
				conn.commit();
				System.out.println("Ŀ�ԿϷ�");
			} catch (SQLException e) {
				System.out.println("����!! Ŀ�Խ���");
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if(conn!=null) {
			try {
				conn.rollback();
				System.out.println("�ѹ�Ϸ�");
			} catch (SQLException e) {
				System.out.println("����!! �ѹ����");
				e.printStackTrace();
			}
		}
	}
	
	
}



