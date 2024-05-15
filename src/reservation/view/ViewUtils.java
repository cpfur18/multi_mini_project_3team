package reservation.view;

// view에서 공통으로 쓰는 메서드가 담긴 파일

public class ViewUtils {
    // 콘솔에 컬러 입히기
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public void printErrorMessage() {
        System.out.println("잘못된 입력 입니다.\n다시 입력해주세요.");
    }

    public void printNoData() {
        System.out.println("데이터 없음");
    }

    public void printQueryFailed() {
        System.out.println("조회에 실패했습니다.");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public static void printColor(String color, String message) {
        switch (color) {
            case RED:
        }
        System.out.print(color + message + RESET);
    }
}
