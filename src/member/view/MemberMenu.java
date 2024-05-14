package member.view;

import member.controller.MemberController;
import member.model.dto.Member;

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

    //    1. 메인페이지: 로그인
    public Member inputLogin() {
        Member m = new Member();
//        System.out.print("아이디 : ");
//        m.setId(sc.next());
//        System.out.print("비밀번호 : ");
//        m.setPw(sc.next());

        return m;
    }
    //    1. 메인페이지: 회원가입
    public Member inputMember() {
        Member m = new Member();
//        System.out.println("새로운 회원정보를 입력하세요 >>");
//        System.out.print("아이디 : ");
//        m.setId(sc.next());
//        System.out.print("비밀번호 : ");
//        m.setPw(sc.next());
//        System.out.print("닉네임 : ");
//        m.setUserName(sc.next());
//        System.out.print("전화번호 : ");
//        m.setPhone(sc.next());
//        m.setMaster("N");
        return m;
    }

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

    public void displaySuccess(String message) {
        System.out.println("서비스 요청 결과 :"+ message);

    }

    public void displayError(String message) {
        System.out.println("서비스 요청 처리 실패 :"+ message);

    }
}
