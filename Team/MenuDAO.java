package Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDAO {

   //멤버변수
   private String url = Main.URL; // 주소
   private String uid = Main.UID; // 계정
   private String upw = Main.UPW; // 비밀번호

   // SELECT
   public ArrayList<MenuVO> selectEx() {

      ArrayList<MenuVO> list = new ArrayList<>();

      String sql = "SELECT * FROM menu order by MNO";

      // 필요한 변수
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null; // 결과 저장 객체
      

      try {
         // 드라이버 로드
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // conn
         conn = DriverManager.getConnection(url, uid, upw);

         // stmt
         pstmt = conn.prepareStatement(sql);

         // sql구문에 ?가 있으면 채워줘야 함

         // sql 실행
         rs = pstmt.executeQuery();

         while(rs.next()) { // 다음 row가 있다면 true
            
            
           int MNO = rs.getInt("MNO");
           String M_NAME = rs.getString("M_NAME"); // 컬럼명
            int PRICE = rs.getInt("PRICE");
            int STOCK  = rs.getInt("Stock");

            // VO는 한번 돌때마다 하나씩 생성되어야함
            // vo에 행 저장
            // vo를 list에 저장
            MenuVO vo = new MenuVO(MNO,M_NAME,PRICE,STOCK);
            list.add(vo);
            
         }
      } catch (Exception e) {
        
      } finally {
         try {
            conn.close();
            pstmt.close();
            rs.close();
         } catch (SQLException e) {
            System.out.println("close 에러");
         }

      }


      return list;
   }

   
   
   //INSERT
   public int insertEx(String NAME, int PRICE, int STOCK) {
      int result = 0;

      String sql = "insert into MENU values(Menu_seq.nextval, ?, ?, ?)";
      Connection conn = null;
      PreparedStatement pstmt = null;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

         //connection
         conn = DriverManager.getConnection(url, uid, upw);
         System.out.println(conn);
       

         //statement객체
         pstmt = conn.prepareStatement(sql);

         //3. ?값 세팅 - 첫번째부터 1번 순서 (setString, setInt, setDate, setTimestamp 등등)
         pstmt.setString(1, NAME);
         pstmt.setInt(2, PRICE);
         pstmt.setInt(3,STOCK);

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

  

//업데이트
public int updateEx(String name, int price, int stock, String m_name) {
	int result = 0;


String sql ="update menu set M_NAME = ?, PRICE = ?, STOCK = ? WHERE M_NAME = ? ";
       
 	
		Connection conn = null;
	     PreparedStatement pstmt = null;
	     


try {
	  Class.forName("oracle.jdbc.driver.OracleDriver");
    
    //connection
    conn = DriverManager.getConnection(url, uid, upw);
 
    
    //statement객체
   
    
    pstmt = conn.prepareStatement(sql);
    
    
    pstmt.setString(1, name);
    pstmt.setInt(2, price);
    pstmt.setInt(3, stock);
    pstmt.setString(4, m_name);
    //sql 실행
   result = pstmt.executeUpdate(); // 성공, 실패 결과를 정수로 반환해줌, 이미 위에서 sql을 pstmt에 담아줬기 때문에 매개변수가 없는 메소드를 선택해야 함
    
   if(result == 1) {
       System.out.println("성공");
    } else {
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

public int deleteEx(String name) { // 삭제
    int result = 0;

    String sql = "delete from menu where m_name = ?";
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
 
 
}


