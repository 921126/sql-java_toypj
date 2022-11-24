import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MenuDAO {

	private String url = Main.URL; // 주소
	private String uid = Main.UID; // 계정
	private String upw = Main.UPW; // 비밀번호
	
	
	public ArrayList<MenuVO> selectEx() { // 검색

		ArrayList<MenuVO> list = new ArrayList<>();

		String sql = "select * from menu order by mno asc";

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
				
				// 한 행에 대한 처리(getInt, getString, getDouble, getDate, getTimestamp 등등)
				int m_no = rs.getInt("mno");
				String m_name = rs.getString("m_name"); // 컬럼명
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");

				// VO는 한번 돌때마다 하나씩 생성되어야함
				// vo에 행 저장
				// vo를 list에 저장
				MenuVO vo = new MenuVO(m_no, m_name, price, stock);
				list.add(vo);
				
				
				
			}


		} catch (Exception e) {
			// TODO: handle exception
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
	
	
	public int insertEx(String name, int price, int stock) { // 추가
		int result = 0;

		String sql = "insert into menu values(menu_seq.nextval, ?, ?, ?)";
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
			pstmt.setInt(2, price);
			pstmt.setInt(3, stock);

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
	
	public int updateEx(String name, int price, int stock) { // 수정
		int result = 0;

		String sql = "update menu\r\n"
				+ "set m_name = ?, price = ?, stock = ?\r\n"
				+ "where m_name = ?";
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
			pstmt.setInt(2, price);
			pstmt.setInt(3, stock);

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
