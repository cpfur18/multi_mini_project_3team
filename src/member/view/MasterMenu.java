package member.view;

import member.controller.MemberController;

import java.util.Scanner;

public class MasterMenu {

    private static Scanner sc = new Scanner(System.in);
    private MemberController memberController = new MemberController();

    //3. 메인페이지 - 관리자페이지 MasterMenu
    public void masterMenu(){
        int choice;

        do {
            System.out.println("--> 관리자 로그인 성공 ");
            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│                    카페 예약 관리 서비스 │");
            System.out.println("│              **티데이**                │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│  1.회원관리                            │"); //회원
            System.out.println("│  2.게시글관리                           │");
            System.out.println("│  3.공지관리                            │");
            System.out.println("│  4.예약관리                            │");
            System.out.println("│  5.상품관리                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.println("번호를 선택하세요 : ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
//                    memberController.masterpage();
                    break;
                case 2:
                    //게시글관리
                    break;
                case 3:
                    //공지관리
                    break;
                case 4:
                    //예약관리
                    break;
                case 5:
                    //상품관리
                    break;
                default:
                    System.out.println("번호를 잘못입력하였습니다.");
            }
        } while (true);
    }
}
