package hayoung;

import java.sql.*;
import java.util.ArrayList;

public class SalesDAO {
	
	private String url = MainClass.URL;
	private String uid = MainClass.UID;
	private String upw = MainClass.UPW;
	
	//메서드
	public ArrayList<SalesVO> Select(){
		ArrayList<SalesVO> list = new ArrayList<>();
		
		String sql = "select to_char(b_date,'YY-MM-DD') as day,\r\n"
				+ "       sum(판매수량) as daycount, \r\n"
				+ "       sum(음료별매출) as daysales\r\n"
				+ "from view_sales \r\n"
				+ "group by to_char(b_date,'YY-MM-DD')";
		
		//필수변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//conn
			conn = DriverManager.getConnection(url, uid, upw);
			
			//pstmt
			pstmt = conn.prepareStatement(sql);
			
			//sql문실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				//행처리
				String day = rs.getString("day");
				int dayCount = rs.getInt("daycount");
				int daySales = rs.getInt("daySales");
				
				SalesVO vo= new SalesVO(day, dayCount, daySales);
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				System.out.println("close 에러");
			}
		}
		
		return list;
	}

	public ArrayList<SalesVO> Select(String Day){
		
		ArrayList<SalesVO> list = new ArrayList<>();
		
		String sql = "select to_char(b_date,'YY-MM-DD') as day,\r\n"
				+ "       sum(판매수량) as daycount, \r\n"
				+ "       sum(음료별매출) as daysales\r\n"
				+ "from view_sales \r\n"
				+ "group by to_char(b_date,'YY-MM-DD') having to_char(b_date,'YY-MM-DD') IN ?";
		
		//필수변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//conn
			conn = DriverManager.getConnection(url, uid, upw);
			
			//pstmt
			pstmt = conn.prepareStatement(sql);
			
			//세팅
			pstmt.setString(1, Day);
			
			//sql문실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				while(rs.next()) {
					
					//행처리
					String day = rs.getString("day");
					int dayCount = rs.getInt("daycount");
					int daySales = rs.getInt("daySales");
					
					SalesVO vo= new SalesVO(day, dayCount, daySales);
					list.add(vo);
				}
			}else {
				System.out.println("데이터가 존재하지 않습니다. 메인화면으로 이동합니다.");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				System.out.println("close 에러");
			}
		}
		
		
		
		return list;
	}


}
