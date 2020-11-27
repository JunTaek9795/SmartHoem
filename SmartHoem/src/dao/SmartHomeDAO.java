package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.JdbcUtil;

public class SmartHomeDAO {
		
		static SmartHomeDAO boardDAO; //BoardDAO 객체
		Connection conn;
		
		//싱글톤 생성을위해서 외부에서 객체 생성불가능하게
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
		
		
		// 마지막 온도를 구하는 메소드
		public int selectListCount() {
		//1.해당쿼리 실행
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
		//2.결과리턴
			return no;
			
		}
}
