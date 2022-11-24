package hayoung;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {
	
	private String url = MainClass.URL;
	private String uid = MainClass.UID;
	private String upw = MainClass.UPW;
	
	
	//메서드만들기
	public int InsertCustomer(String name, String phone) {
		int result = 0;
		
		String sql = "insert into customer VALUES(customer_seq.nextval, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//conn
			conn = DriverManager.getConnection(url, uid, upw);
			System.out.println(conn);
			
			//pstmt 객체
			pstmt = conn.prepareStatement(sql);
			
			//? 값 입력
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			result = pstmt.executeUpdate(); //성공실패결과 반환
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				System.out.println("close에러 발생");
			}
		}
		
		return result;
	}

	public ArrayList<CustomerVO> selectEx(){
		
		ArrayList<CustomerVO> list = new ArrayList<>();
		String sql = "SELECT * FROM customer order by cid";
		
		//필수변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select 결과 반환받는 객체
		
		try {
			//드라이버
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//conn
			conn = DriverManager.getConnection(url, uid, upw);
			
			//pstmt
			pstmt = conn.prepareStatement(sql);
			
			//sql문 실행시키기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int cid = rs.getInt("cid");
				String c_name = rs.getString("c_name");
				String phone = rs.getString("phone");
				
				CustomerVO vo = new CustomerVO(cid, c_name, phone);
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
	
	public int UpdateCustomer(String phone, String cid) {
		int result = 0;
		
		String sql = "update customer set phone = ? where cid = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//conn
			conn = DriverManager.getConnection(url,uid,upw);
			
			//pstmt
			pstmt = conn.prepareStatement(sql);
			
			//?값 세팅
			pstmt.setString(1, phone);
			pstmt.setString(2, cid);

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				System.out.println("close 에러");
			}
		}
		
		return result;
		
	}

	public int DeleteCustomer(String cid) {
		int result = 0;

		String sql = "delete from customer where cid = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//conn
			conn = DriverManager.getConnection(url, uid, upw);
			
			//pstmt
			pstmt = conn.prepareStatement(sql);
			
			//?값 세팅
			pstmt.setString(1, cid);
			
			//메서드실행
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				System.out.println("close에러");
			}
		}
		return result;
	}
}
