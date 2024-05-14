package com.multi.jdbc.member.view;

import com.multi.jdbc.member.controller.MemberController;
import com.multi.jdbc.member.model.dto.Member;

import java.util.Scanner;

public class MemberMenu {



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
                    memberController.loginAccount(inputId(), inputPw());
                    break;
                case 2:
                    memberController.createAccount(inputMember());
                    break;

                default:
                    System.out.println("번호를 잘못입력하였습니다.");
            }
        } while (true);
    }


    // 회원가입: 정보 입력
    public Member inputMember() {
        System.out.print("회원 아이디 : ");
        String id = sc.nextLine();
        System.out.print("암호 : ");
        String pw = sc.nextLine();
        System.out.print("이름 : ");
        String userName = sc.nextLine();
        System.out.print("전화번호 : ");
        String phone = sc.nextLine();

        Member m = new Member(id, pw, userName, phone);
        return m;
    }

    // 회원 아이디 입력
    public String inputId() {
        System.out.print("아이디 입력: ");
        return sc.nextLine();
    }
    // 회원 비밀번호 입력
    public String inputPw() {
        System.out.print("비밀번호 입력: ");
        return sc.nextLine();
    }

}
