package reservation.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceMenu {
    private static Scanner sc = new Scanner(System.in); // Scanner 객체 생성
    private ViewUtils viewUtils = new ViewUtils();
    int answer = 0;

    public void serviceMenu() { // 서비스 선택 화면
        do {
            System.out.println("┌────────────────────────────────────────────────────┐");
            System.out.println("│                             카페 예약 관리 서비스  │");
            System.out.println("│                  **티데이**                        │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│ [카페예약]                                         │");
            System.out.println("│ 원하시는 서비스가 있으십니까? [Yes(1)/No(0)]       │");
            System.out.println("└────────────────────────────────────────────────────┘");
            System.out.printf("번호를 입력하세요 : ");
            answer = sc.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("서비스 선택 화면으로 이동합니다.");
                    serviceMenu2();
                    break;
                case 0:
                    System.out.println("예약 시간 선택 화면으로 이동합니다.");
                    break;
                default:
                    viewUtils.printErrorMessage();
            }
        } while (true);
    }

    public void serviceMenu2() { // 서비스 선택 화면에서 YES(1) 선택 시 동작
        do {
            System.out.println("┌────────────────────────────────────────────────────┐");
            System.out.println("│                             카페 예약 관리 서비스  │");
            System.out.println("│                  **티데이**                        │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│ [서비스 선택] 두 번 입력 시 취소                   │");
            System.out.println("│ 원하시는 서비스를 아래 목록에서 선택해주세요.      │");
            System.out.println("│====================================================│");
            System.out.println("│ 1. 전원 콘센트 및 USB 충전                         │");
            System.out.println("│ 2. 소파 유무                                       │");
            System.out.println("│ 3. 창가 자리                                       │");
            System.out.println("│ 4. 조용한 자리                                     │");
            System.out.println("│ 5. 선택 안함                                       │");
            System.out.println("└────────────────────────────────────────────────────┘");

            inputService(); // 서비스 번호 입력

        } while (true);
    }

    public void inputService(){ // 번호 입력
        List<String> answerList = new ArrayList<>();
        do {
            if (!answerList.isEmpty()){
                System.out.print("현재 선택한 서비스 : ");
                for(String l : answerList) {
                    System.out.print(l + " ");
                }

            }
            System.out.print("\n번호를 입력하세요 : ");
            answer = sc.nextInt();

            switch (answer) {
                case 1: case 2: case 3: case 4:
                    // 배열에 넣어서 체크한 뒤 동일한 서비스 선택 시 DEL
                    if(!answerList.contains(Integer.toString(answer))){
                        System.out.println("서비스가 추가되었습니다.");
                        answerList.add(Integer.toString(answer));
                        System.out.println(answerList);
                    } else {
                        System.out.println("서비스가 삭제되었습니다.");
                        answerList.remove(Integer.toString(answer));
                    }
                    break;
                case 5:
                    System.out.println("서비스를 선택하지 않으셨습니다.");
                    System.out.println("예약 시간 선택 화면으로 이동합니다.");
                    new TimeMenu().timeMenu(null, 0);
                default:
                    viewUtils.printErrorMessage();
            }
            do {
                System.out.println("더 입력하시겠습니까?[Yes(1)/No(0)] : ");
                answer = sc.nextInt();

                switch (answer) {
                    case 1:
                        answer = 0;
                        break;
                    case 0:
                        System.out.println("서비스 입력을 종료합니다.");
                        System.out.println("예약 시간 선택 화면으로 이동합니다.");
                        List<String> answer2 = new ArrayList<>();
                        for (String answer : answerList) {
                            answer2.add("S" + answer);
                        }
                        String serviceString = String.join(", ", answer2);
                        new TimeMenu().timeMenu(serviceString, answer2.size());
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            } while (answer != 0);

        } while (true);
    }
}
