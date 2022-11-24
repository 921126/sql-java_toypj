package Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
	public static final String UID = "com01";
	public static final String UPW = "com01";
	
	public static void main(String[] args) {
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		CustomerDAO customerDAO = new CustomerDAO();
		
		while(flag) {
			try {
				System.out.println("-- 1.회원 목록 조회 | 2.회원 추가 | 3. 회원 수정 | 4.회원 삭제 | 5.종료 --");
				
				String menu = scan.next();
				switch (menu) {
				case "1": //회원조희
					System.out.println("----- 회원목록 -----");
					ArrayList<CustomerVO> list = customerDAO.customerList();
					
					for(CustomerVO vo : list) {
						System.out.println(vo);
					}
					break;
					//
				case "2":
					System.out.println("-- 회원 정보 추가 --");
					System.out.print("회원 이름>");
					String name = scan.next();
					System.out.print("회원 연락처>");
					String phone = scan.next();
					System.out.println("추가할 회원의 정보:"+name+" | 연락처:"+phone+"이(가) 맞습니까?");
					System.out.println("1.예 |2.아니오");
					int result = 0;
					int num = scan.nextInt();
					switch (num) {
					case 1:
						result = customerDAO.insertCustomer(name, phone);
						if(result == 1) {
							System.out.println("회원 정보 추가 성공");
						}else {
							System.out.println("회원 정보 추가 실패");
						}
						break;
					case 2:
						System.out.println("회원 정보 추가를 취소합니다.");
						break;
					default:
						System.out.println("올바른 번호를 입력해주세요. 본 메뉴로 돌아갑니다.");
						break;
					}

					break;

					//
				case "3":
					System.out.println("-- 회원 정보 수정 --");
					System.out.print("회원 번호>");
					int cid = scan.nextInt();
					System.out.print("수정할 이름>");
					String modifiedName = scan.next();
					System.out.print("수정할 번호>");
					String modifiedPhone = scan.next();
					System.out.println(cid+ " 번 회원|이름:" + modifiedName + " | 번호:" + modifiedPhone + "로 수정하겠습니까?");
					System.out.println("1.예 |2.아니오");
					num = scan.nextInt();
					switch (num) {
					case 1:
						 System.out.println("회원 정보가 수정되었습니다.");
						result = customerDAO.updateCustomer(modifiedName, modifiedPhone, cid);
						break;
					case 2:
						System.out.println("회원 정보 수정을 취소합니다.");
						break;
					default:
						System.out.println("올바른 번호를 입력해주세요. 본 메뉴로 돌아갑니다.");
						break;
					}

					break;
					//
				case "4":
					System.out.println("-- 회원 정보 삭제 --");
					System.out.print("제거할 회원 번호>");
					cid = scan.nextInt();
					System.out.println(cid + "번 회원 정보를 삭제하시겠습니까?");
					System.out.println("1.예 | 2.아니오");
					num = scan.nextInt();
					switch (num) {
					case 1:
						System.out.println("회원 정보가 삭제되었습니다.");
						result = customerDAO.deleteCustomer(cid);
						break;
					case 2:
						System.out.println("회원 정보 삭제를 취소합니다.");
						break;

					default:
						System.out.println("올바른 번호를 입력해주세요. 본 메뉴로 돌아갑니다.");
						break;
					}
					break;
					//
				case "5":
					System.out.println("- 종료 -");
					flag = false;
					break;
				}
			} catch (Exception e) {
		          e.printStackTrace();
			}
		}
	}
}
