import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String UID = "com01";
	public static final String UPW = "com01";

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String temp = "";

		MenuDAO menuDAO = new MenuDAO();
		StockDAO stockDAO = new StockDAO();
		BuyingDAO buyingDAO = new BuyingDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		
		while(true) {

			try {

				System.out.println("1. 매출 관리, 2. 메뉴 관리, 3. 회원 관리, 4. 재고 관리, 5. 주문 관리");

				String menu = scan.next();
				scan.nextLine();

				switch (menu) {
				case "1":
				case "매출":
					System.out.println("1. 매출 보기, 2. 매출 집계하기"); // select / insert
					temp = scan.next();

					if(temp.equals("1")) {

					} else if (temp.equals("2")) {

					} else {
						System.out.println("다시 입력해주세요");
						continue;

					}

					break;

				case "2":
				case "메뉴":
					System.out.println("1. 메뉴 보기, 2. 메뉴 수정하기, 3. 메뉴 추가하기, 4. 메뉴 삭제하기"); // select / update / insert / delete
					temp = scan.next();

					if(temp.equals("1")) {
						ArrayList<MenuVO> list = menuDAO.selectEx();

						for(MenuVO vo : list) {
							System.out.println(vo.toString());
						}

					} else if (temp.equals("2")) {





					} else if (temp.equals("3")) {
						System.out.print("메뉴 이름>");
						String name = scan.next();
						System.out.print("메뉴 가격>");
						int price = scan.nextInt();
						System.out.print("메뉴 재고량>");
						int stock = scan.nextInt();

						int result = menuDAO.insertEx(name, price, stock);

						if(result == 1) {
							System.out.println("정상 입력되었습니다");
						} else {
							System.out.println("입력 오류 발생");
						}

					} else if (temp.equals("4")) {
						System.out.print("메뉴 이름>");
						String name = scan.next();

						int result = menuDAO.deleteEx(name);

						if(result == 1) {
							System.out.println("정상 입력되었습니다");
						} else {
							System.out.println("입력 오류 발생");
						}

					} else {
						System.out.println("다시 입력해주세요");
						continue;
					}


					break;

				case "3":
				case "회원":
					System.out.println("1. 회원 목록보기, 2. 회원정보 수정하기, 3. 회원 추가하기, 4. 회원 삭제하기"); // select / update / insert / drop
					temp = scan.next();

					if(temp.equals("1")) {

					} else if (temp.equals("2")) {

					} else if (temp.equals("3")) {

					} else {
						System.out.println("다시 입력해주세요");
						continue;
					}

					break;

				case "4":
				case "재고 관리":
					System.out.println("1. 재고 확인하기, 2. 재고 추가하기"); // select / insert
					temp = scan.next();

					if(temp.equals("1")) {
						// 멤버쉽 관련 추가해야함
						ArrayList<StockVO> list = stockDAO.selectEx();

						for(StockVO vo : list) {
							System.out.println(vo.toString());
						}

					} else if (temp.equals("2")) {
						System.out.print("재고를 바꿀 메뉴 이름>");
						String name = scan.next();

						System.out.print("최종 재고량>");
						int stock = scan.nextInt();

						int result = stockDAO.updateEx(name, stock);

						if(result == 1) {
							System.out.println("정상 입력되었습니다. " + name + "의 재고량: " + stock);
						} else {
							System.out.println("입력 오류 발생");
						}
					} else {
						System.out.println("다시 입력해주세요");
						continue;
					}

					break;		

				case "5":
				case "주문 관리":
					System.out.println("1. 주문하기, 2. 주문 목록보기"); // select / insert
					temp = scan.next();
					System.out.println("기다려주세요...");
					if(temp.equals("1")) {
						ArrayList<CustomerVO> list5 = customerDAO.customerList();
						ArrayList<Integer> list6 = new ArrayList<Integer>(); // 회원번호
						ArrayList<String> list7 = new ArrayList<String>(); // 회원명
						for(CustomerVO vo : list5) {
							
							list6.add(vo.getCid());
							list7.add(vo.getName());
						}
						int[] arr5 = list6.stream()
				                .mapToInt(Integer::intValue)
				                .toArray();
						
					    String[] arr6 = new String[list7.size()];
					    int size=0;
					    for(String temp2 : list7){
					      arr6[size++] = temp2;
					    }
											    
					    
						System.out.println("회원번호를 입력하세요");
												
						int count = 0;
						int count4 = 0;
						count = scan.nextInt(); // 2
						for(int i = 0; i < arr5.length; i++) {
							if(count == arr5[i]) {
								System.out.println(arr6[i] + "회원님 안녕하세요!");
								count4 = count;
							}
						}
						
						
						a : while(true) {
						ArrayList<StockVO> list = stockDAO.selectEx();
						ArrayList<Integer> list2 = new ArrayList<Integer>(); // 상품번호
						ArrayList<String> list3 = new ArrayList<String>(); // 상품명
						ArrayList<Integer> list4 = new ArrayList<Integer>(); // 상품재고량
						
						
						for(StockVO vo : list) {
							System.out.println("상품번호: " + vo.getM_no() + " <" + vo.getM_name() + "> 잔여수량: " + vo.getStock());
							
							list2.add(vo.getM_no());
							list3.add(vo.getM_name());
							list4.add(vo.getStock());
						}
					    int[] arr2 = list2.stream()
				                .mapToInt(Integer::intValue)
				                .toArray();
						
					    String[] arr3 = new String[list3.size()];
					    size=0;
					    for(String temp2 : list3){
					      arr3[size++] = temp2;
					    }
					    
					    int[] arr4 = list4.stream()
				                .mapToInt(Integer::intValue)
				                .toArray();
					    
					    System.out.println(Arrays.toString(arr2));
						System.out.println(Arrays.toString(arr3));
						System.out.println(Arrays.toString(arr4));
						
						
						System.out.print("구매할 상품의 상품번호를 입력하세요>");
						count = 0;
						count = scan.nextInt(); // 2
						int count3 = 0;
						for(int i = 0; i < arr2.length; i++) {
							if(count == i+1) {
								System.out.print(arr3[i]);
								count3 = arr4[i];
								
							}
						}
						
						
						System.out.println(": 구매하실 잔 수를 입력하세요");
						
						b : while(true) {
						int count2 = 0;
						count2 = scan.nextInt();
						
						if(count2 > count3) {
							System.out.println("잔여수량 초과입니다. 다시 입력해주세요");
						} else {
							System.out.println(count2 + "잔 주문하셨습니다.");
							
							int result = buyingDAO.insertEx(count, count2, count4);
							
							if(result == 1) {
								System.out.println("정상 주문되었습니다");
							} else {
								System.out.println("입력 오류 발생");
							}


							int result2 = stockDAO.updateEx(arr3[count-1], count3 - count2);

							if(result2 == 1) {
//								System.out.println(arr3[count-1] + "의 재고량: " + (count3 - count2));
							} else {
								System.out.println("재고 오류 발생");
							}
							
							
							
							
							
							System.out.println("더 주문하시려면 0번을, 초기화면으로 돌아가시려면 아무 숫자나 눌러주세요");
								count2 = scan.nextInt();
								if(count2 == 0) {
									break b;
								} else {
									break a;
								} 
							
						}
						
						}
						}
						
					} else if (temp.equals("2")) {
						ArrayList<BuyingVO> list = buyingDAO.selectEx();

						for(BuyingVO vo : list) {
							System.out.println(vo.toString());
						}
						
						
						
					} else {
						System.out.println("다시 입력해주세요");
						continue;
					}

					break;	

				}


			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
