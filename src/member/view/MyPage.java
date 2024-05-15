package member.view;

import member.controller.MemberController;

import java.util.Scanner;

public class MyPage {

    private static Scanner sc = new Scanner(System.in);
    private MemberController memberController = new MemberController();

    //2-2. 메인페이지 - 회원페이지 - [마이페이지]
    public void mypage(){
        int choice;

        do {
            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│                    카페 예약 관리 서비스 │");
            System.out.println("│              **티데이**                │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│  [마이페이지]                           │");
            System.out.println("│                                       │");
            System.out.println("│  1.회원 탈퇴                           │");
            System.out.println("│  2.회원 정보 조회                       │");
            System.out.println("│  3.회원 정보 수정                       │");
            System.out.println("│  0.돌아가기                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.println("번호를 선택하세요 : ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
//                    memberController.deleteAccount();
                    break;
                case 2:
//                    memberController.infoAccount();
                    break;
                case 3:
//                    memberController.updateAccount();
                    break;
                case 0:
//                    memberPage.open();
                    break;

                default:
                    System.out.println("번호를 잘못입력하였습니다.");
            }
        } while (true);
    }


}
