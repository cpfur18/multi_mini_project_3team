package member.controller;

import member.model.dto.Member;
import member.service.MemberService;

public class MemberController {

    private MemberService memberService = new MemberService();

    public void loginAccount(Member m) {

//        Member mem = new Member();
//        int m = memberService.loginAccount(mem);
//        if (m != null) {
//            new MemberMenu().displaySuccess("로그인 성공");
//
//            Member mem = memberService.loginAccount(m);
//            new MemberMenu().memberPage(mem);
//        } else {
//            new MemberMenu().displayError("로그인 실패, 관리자에 문의하세요 ");
//        }

    }

    public void createAccount(Member m) {
//        int result = 0;
//
//        result = memberService.createAccount(m);
//        if (result > 0){
//            new MemberMenu().displaySuccess("회원가입 성공");
//        }else{
//            new MemberMenu().displayError("회원가입 실패, 관리자에 문의하세요 ");
//        }
    }
}
