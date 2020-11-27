package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.JdbcUtil;

public class SmartHomeDAO {
		
		static SmartHomeDAO boardDAO; //BoardDAO ��ü
		Connection conn;
		
		//�̱��� ���������ؼ� �ܺο��� ��ü �����Ұ����ϰ�
		private SmartHomeDAO(){
			
		}
		public static SmartHomeDAO getInstance(){
			if(boardDAO==null) {	
				boardDAO = new SmartHomeDAO();
			}
			return boardDAO;
		}
		
		public void setConection(Connection conn){
			this.conn=conn;
		}
		
		
		// ������ �µ��� ���ϴ� �޼ҵ�
		public int selectListCount() {
		//1.�ش����� ����
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int no = 0;
			try {
				pstmt = conn.prepareStatement("SELECT date,Temperature FROM smarthoem WHERE NO=(SELECT MAX(NO) FROM smarthoem);");
				rs = pstmt.executeQuery();
				rs.next();
				no = rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		//2.�������
			return no;
			
		}
}
