package hayoung;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	//상수선언
	public static final String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
	public static final String UID = "com01";
	public static final String UPW = "com01";


	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		//클래스선언
		CustomerDAO cDAO = new CustomerDAO();
		SalesDAO sDAO = new SalesDAO();

		re : while(true) {

			System.out.println("까페관리 시스템");
			System.out.println("메뉴선택 [1.회원관리  2.메뉴관리  3.주문관리  4.매출조회 5.종료]");
			String menu = sc.next();

			try {
				sw : switch (menu) {
				case "1":

					System.out.println("까페관리 시스템 > 회원관리 메뉴");
					System.out.println("세부 메뉴선택 [1. 회원목록보기  2.회원정보 수정  3.회원추가하기  4.회원삭제하기  5.돌아가기]");
					String num = sc.next();

					switch (num) {
					case "1":
						ArrayList<CustomerVO> list = cDAO.selectEx();
						for(CustomerVO vo : list) {
							System.out.println(vo.toString());
						}
						break;
					case "2":
						System.out.println("까페관리 시스템 > 회원관리 메뉴 > 회원정보 수정");
						System.out.print("신규 전화번호 > ");
						String phone = sc.next();
						System.out.print("유저번호 > ");
						String cid = sc.next();

						int result = cDAO.UpdateCustomer(phone, cid);
						if(result == 1) {
							System.out.println("정상적으로 업데이트 되었습니다.");
						}else {
							System.out.println("입력 오류 발생");
						}
						break;
					case "3":
						System.out.println("까페관리 시스템 > 회원관리 메뉴 > 회원추가하기");
						System.out.print("이름 > ");
						String name = sc.next();
						System.out.print("전화번호 > ");
						String p = sc.next();

						int r2 = cDAO.InsertCustomer(name, p);
						if(r2 == 1) {
							System.out.println("정상적으로 추가 되었습니다.");
						}else {
							System.out.println("입력 오류 발생");
						}
						break;
					case "4":
						System.out.println("까페관리 시스템 > 회원관리 메뉴 > 회원삭제하기");
						System.out.print("회원번호 > ");
						String id = sc.next();

						int r3 = cDAO.DeleteCustomer(id);
						if(r3 == 1) {
							System.out.println("정상적으로 삭제되었습니다.");
						}else {
							System.out.println("입력 오류 발생");
						}

						break;
					case "5":
						System.out.println("이전화면으로 돌아갑니다.");
						break sw;
					default:
						System.out.println("1~5번으로 입력해주세요.");
						break;
					}


					break;
				case "2":

					break;
				case "3":

					break;
				case "4":
					System.out.println("까페관리 시스템 > 매출조회 메뉴");
					System.out.println("세부 메뉴선택 [1. 전체 매출 조회 2. 특정날짜 매출 조회  3.돌아가기]");
					String num2 = sc.next();

					sa: switch (num2) {
					case "1":
						ArrayList<SalesVO> list2 = sDAO.Select();
						for(SalesVO vo : list2) {
							System.out.println(vo.toString());
						}
						break;
					case "2":
						System.out.println("확인하고 싶은 날짜를 YY-MM-DD로 입력해주세요.");
						String day = sc.next();

						//유효성검사 위치
						CheckDate.checDate(day);

						if(CheckDate.checDate(day) == true) {
							ArrayList<SalesVO> list3 = sDAO.Select(day);
							for(SalesVO vo : list3) {
								System.out.println(vo.toString());

							}
						}else {
							System.out.println("날짜형식이 잘못되었습니다. 초기화면으로 돌아갑니다.");
						}

						continue;
					case "3":
						System.out.println("이전화면으로 돌아갑니다.");
						break sa;
					default:
						System.out.println("1~3번 숫자를 입력해주세요.");
						break;
					}

					break;
				case "5":
					System.out.println("시스템을 종료합니다.");
					sc.close();
					break re;
				default:
					System.out.println("1 ~ 5번 번호를 입력해주세요.");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
