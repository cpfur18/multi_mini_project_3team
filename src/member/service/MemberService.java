package member.service;

import member.model.dao.MemberDao;
import member.model.dto.Member;

/* Service 클래스에서 메소드 작성 방법
 * 1) Controller로 부터 인자를 전달받음
 * 2) Connection 객체 생성
 * 3) Dao 객체 생성
 * 4) Dao로 생성한 Connection 객체와 인자를 전달
 * 5) Dao 수행 결과를 가지고 비즈니스 로직 및 트랜잭션 관리를 함 */
public class MemberService {

    private MemberDao memberDao;

    public MemberService() {
        this.memberDao = new MemberDao();
    }

    //로그인
    public static int loginAccount(Member m) {
        int rs = 0;

        return rs;
    }

    //회원가입
    public int createAccount(Member m) {
        int rs = 0;

        return rs;
    }

    //deleteMember() infoMember() updateMember()
    //회원 삭제

    //회원 정보 조회

    //회원 정보 수정

    //deleteAccount() infoAccount() updateAccount()
    //회원 탈퇴

    //회원 정보 조회

    //회원 정보 수정
}
