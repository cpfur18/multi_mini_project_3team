package member.view;

import member.controller.MemberController;
import member.model.dto.Member;

import java.util.Scanner;

public class MemberMenu {

    private static Scanner sc = new Scanner(System.in);
    private MemberController memberController = new MemberController();

    //2. 메인페이지 - 회원페이지
    public void memberPage(Member m){
        int choice;

        do {
            System.out.println("--> 회원 로그인 성공 ");
            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│                    카페 예약 관리 서비스 │");
            System.out.println("│              **티데이**                │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│                                       │");
            System.out.println("│  1.마이페이지                           │"); //회원
            System.out.println("│  2.게시글                              │");
            System.out.println("│  3.예약                                │");
            System.out.println("│  4.상품                                │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.println("번호를 선택하세요 : ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
//                    memberController.mypage();
                    break;
                case 2:
                    //게시글
                    break;
                case 3:
                    //예약
                    break;
                case 4:
                    //상품
                    break;

                default:
                    System.out.println("번호를 잘못입력하였습니다.");
            }
        } while (true);
    }

}
