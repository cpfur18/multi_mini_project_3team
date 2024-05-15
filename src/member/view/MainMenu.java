package member.view;

import member.controller.MemberController;
import member.model.dto.Member;

import java.util.Scanner;

public class MainMenu {

    private static Scanner sc = new Scanner(System.in);
    private MemberController memberController = new MemberController();

    //메인페이지
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

            switch (choice) { //loginAccount() createAccount()
                case 1:
                    memberController.loginAccount(inputLogin());
                    break;
                case 2:
                    memberController.createAccount(inputMember());
                    break;

                default:
                    System.out.println("번호를 잘못입력하였습니다.");
            }
        } while (true);
    }

    //로그인
    public Member inputLogin() {
        Member m = new Member();
        System.out.print("아이디 : ");
        m.setId(sc.next());
        System.out.print("비밀번호 : ");
        m.setPw(sc.next());

        return m;
    }

    //회원가입
    public Member inputMember() {
        Member m = new Member();
        System.out.println("새로운 회원정보를 입력하세요 >>");
        System.out.print("아이디 : ");
        m.setId(sc.next());
        System.out.print("비밀번호 : ");
        m.setPw(sc.next());
        System.out.print("닉네임 : ");
        m.setUserName(sc.next());
        System.out.print("전화번호 : ");
        m.setPhone(sc.next());
        m.setMaster('N');

        return m;
    }
}
