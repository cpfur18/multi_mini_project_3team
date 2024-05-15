package member.controller;

import member.model.dto.Member;
import member.service.MemberService;

public class MemberController {

    private MemberService memberService = new MemberService();

    // MainMenu 로그인
    public void loginAccount(Member m) {
        //m != 0이면 로그인 성공
    }

    //MainMenu 회원가입
    public void createAccount(Member m) {

    }

    //MasterPage 회원 삭제
    public void deleteMember() {
    }

    //MasterPage 회원 정보 조회
    public void infoMember() {
    }

    //MasterPage 회원 정보 수정
    public void updateMember() {
    }

    //MyPage 회원 탈퇴
    public void deleteAccount() {
    }

    //MyPage 회원 정보 조회
    public void infoAccount() {
    }

    //MyPage 회원 정보 수정
    public void updateAccount() {
    }
}
