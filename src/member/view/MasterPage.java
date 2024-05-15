package member.view;

import member.controller.MemberController;

import java.util.Scanner;

public class MasterPage {

    private static Scanner sc = new Scanner(System.in);
    private MemberController memberController = new MemberController();

    //3-3. 메인페이지 - 관리자페이지 - [회원관리 Masterpage]
    public void masterPage(){
        int choice;

        do {
            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│                    카페 예약 관리 서비스 │");
            System.out.println("│              **티데이**                │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│  [회원관리]                             │");
            System.out.println("│                                       │");
            System.out.println("│  1.회원 삭제                            │");
            System.out.println("│  2.회원 정보 조회                       │");
            System.out.println("│  3.회원 정보 수정                       │");
            System.out.println("│  0.돌아가기                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.println("번호를 선택하세요 : ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
//                    memberController.masterpage();
                    break;
                case 2:
//                    memberController.infoAccountAll();
                    break;
                case 3:
//                    memberController.updateAccountOne();
                    break;
                case 0:
//                    masterMenu.open();
                    break;
                default:
                    System.out.println("번호를 잘못입력하였습니다.");
            }
        } while (true);
    }
}
