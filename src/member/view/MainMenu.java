package member.view;

import member.controller.MemberController;

import java.util.Scanner;

public class MainMenu {

    private static Scanner sc = new Scanner(System.in);
    private MemberController memberController = new MemberController();

    //1. 메인페이지
    public void mainMenu() {
        int choice;

        do {
            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│                    카페 예약 관리 서비스 │");
            System.out.println("│              **티데이**                │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│  1.로그인                              │");
            System.out.println("│  2.회원가입                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.println("번호를 선택하세요 : ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
//                    memberController.loginAccount(inputLogin());
                    break;
                case 2:
//                    memberController.createAccount(inputMember());
                    break;

                default:
                    System.out.println("번호를 잘못입력하였습니다.");
            }
        } while (true);
    }
}
