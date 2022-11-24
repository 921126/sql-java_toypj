package Team;

import java.util.ArrayList;
import java.util.Scanner;




public class Main {
	// public static final String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
   public static final String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
   public static final String UID = "com01";
   public static final String UPW = "com01";

   public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
      

      String temp = "";

      MenuDAO MenuDAO = new MenuDAO();
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
               System.out.println("1. 메뉴 보기, 2. 메뉴 수정하기, 3. 메뉴 추가하기, 4. 메뉴 삭제하기"); // select / update / insert / drop
               temp = scan.next();
               
               if(temp.equals("1")) {
            	   ArrayList<MenuVO> list =MenuDAO.selectEx();
            	   for(MenuVO vo : list) {
   					System.out.println(vo.toString());
   				}
            	   
            		  
               } else if (temp.equals("2")) {
            
            	 System.out.println("어떤 메뉴를 바꾸시겠습니까?");
              	 String m_name = scan.next();  
              	 System.out.println("변경하실 이름을 작성해주세요");
            	 String name = scan.next();
            	 System.out.println("가격: ");
            	 int price = scan.nextInt();
            	 System.out.println("재고:");
            	 int stock = scan.nextInt();
            	 
            	
            int result = MenuDAO.updateEx(name, price, stock, m_name);	 
            	
            if(result ==1) {
            	System.out.println("성공입니다");
            } else {
            	System.out.println("실패입니다");
            }
            	
               
               
               } else if (temp.equals("3")) {
            	   System.out.println("메뉴이름 : ");
            	   String name = scan.next();
            	   System.out.println("가격: ");
            	   int price = scan.nextInt();
            	   System.out.println("재고");
            	   int stock = scan.nextInt();
            	   
                  int result = MenuDAO.insertEx(name, price, stock);
                  
                  if(result == 1) {
                	  System.out.println("정상 입력되었습니다.");
                  } else {
                  System.out.println("입력 오류 발생");
               }
               
               } else if (temp.equals("4")) {
                   System.out.print("메뉴 이름>");
                   String name = scan.next();

                   int result = MenuDAO.deleteEx(name);

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
                  
               } else if (temp.equals("2")) {
                  
               } else {
                  System.out.println("다시 입력해주세요");
                  continue;
               }
               
               break;      
               
            case "5":
            case "주문 관리":
               System.out.println("1. 주문하기, 2. 주문 목록보기"); // select / insert
               temp = scan.next();
               
               if(temp.equals("1")) {
                  
               } else if (temp.equals("2")) {
                  
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