package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDAO {
	private String url = Main.URL;
	private String uid = Main.UID;
	private String upw = Main.UPW;
	
	// 회원 목록 조회 메서드
	public ArrayList<CustomerVO> customerList() {
		ArrayList<CustomerVO> list = new ArrayList<>();
		
		String sql = "select * from CUSTOMER";
		
        Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           
           //connection
           conn = DriverManager.getConnection(url, uid, upw);
           
           //statement객체
           pstmt = conn.prepareStatement(sql);
           
           //3. ?값 세팅 - 첫번째부터 1번 순서 (setString, setInt, setDate, setTimestamp 등등)
           
           //4. sql 실행 (select문은 query문장 실행, insert, delete, update문은 update메소드로 실행)
           rs = pstmt.executeQuery(); // 성공, 실패 결과를 정수로 반환해줌, 이미 위에서 sql을 pstmt에 담아줬기 때문에 매개변수가 없는 메소드를 선택해야 함
           while(rs.next()) { //다음 row가 있다면 true
        	   int cid = rs.getInt("CID");
        	   String name = rs.getString("C_NAME"); // 컬럼명
        	   String phone = rs.getString("PHONE");
        	   CustomerVO cvo = new CustomerVO(cid, name, phone);
				list.add(cvo);
			}
           
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           try {
              conn.close();
              pstmt.close();
              rs.close();
           } catch (SQLException e) {
              e.printStackTrace();
              System.out.println("Close 에러");
           }
        }
        return list;
	}
	
	//회원 추가 메서드
	public int insertCustomer(String name, String phone) {
		int result = 0;
		
		 String sql = "insert into customer values(customer_seq.nextval, ?, ?)";
         Connection conn = null;
         PreparedStatement pstmt = null;
         
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //connection
            conn = DriverManager.getConnection(url, uid, upw);
            
            //statement객체
            pstmt = conn.prepareStatement(sql);
            
            //3. ?값 세팅 - 첫번째부터 1번 순서 (setString, setInt, setDate, setTimestamp 등등)
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            
            //4. sql 실행 (select문은 query문장 실행, insert, delete, update문은 update메소드로 실행)
            result = pstmt.executeUpdate(); // 성공, 실패 결과를 정수로 반환해줌, 이미 위에서 sql을 pstmt에 담아줬기 때문에 매개변수가 없는 메소드를 선택해야 함
            
            
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            try {
               conn.close();
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
               System.out.println("Close 에러");
            }
         }
		
		return result;
		
	}

	//회원 수정
	public int updateCustomer(String name, String phone, int cid) {
		int result = 0;
		
		String sql = "update CUSTOMER set C_NAME = ?, PHONE = ? where CID = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           
           //connection
           conn = DriverManager.getConnection(url, uid, upw);
           
           //statement객체
           pstmt = conn.prepareStatement(sql);
           
           //3. ?값 세팅 - 첫번째부터 1번 순서 (setString, setInt, setDate, setTimestamp 등등)
           pstmt.setString(1, name);
           pstmt.setString(2, phone);
           pstmt.setInt(3, cid);
           
           //4. sql 실행 (select문은 query문장 실행, insert, delete, update문은 update메소드로 실행)
           result = pstmt.executeUpdate(); // 성공, 실패 결과를 정수로 반환해줌, 이미 위에서 sql을 pstmt에 담아줬기 때문에 매개변수가 없는 메소드를 선택해야 함

			if(result == 1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           try {
              conn.close();
              pstmt.close();
           } catch (SQLException e) {
              e.printStackTrace();
              System.out.println("Close 에러");
           }
        }
		
		return result;
	}
	
	//회원삭제
	public int deleteCustomer(int cid) {
		int result = 0;
		
		String sql = "delete from CUSTOMER where cid = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           
           //connection
           conn = DriverManager.getConnection(url, uid, upw);
           
           //statement객체
           pstmt = conn.prepareStatement(sql);
           
           //3. ?값 세팅 - 첫번째부터 1번 순서 (setString, setInt, setDate, setTimestamp 등등)
           pstmt.setInt(1, cid);
           
           //4. sql 실행 (select문은 query문장 실행, insert, delete, update문은 update메소드로 실행)
           result = pstmt.executeUpdate(); // 성공, 실패 결과를 정수로 반환해줌, 이미 위에서 sql을 pstmt에 담아줬기 때문에 매개변수가 없는 메소드를 선택해야 함

			if(result == 1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           try {
              conn.close();
              pstmt.close();
           } catch (SQLException e) {
              e.printStackTrace();
              System.out.println("Close 에러");
           }
        }
		return result;
	}
	
}
