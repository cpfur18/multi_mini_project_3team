package reservation.controller;

import common.excption.TimeException;
import reservation.model.dto.Time;
import reservation.service.TimeService;
import reservation.view.TimeMenu;

public class TimeController {
    private TimeService timeService = new TimeService();
    public void selectOne(int memberId) {
//        TimeMenu tMenu = new TimeMenu();
        Time t = null;
        TimeMenu menu = new TimeMenu();
        try {
            t = timeService.selectOne(Integer.toString(memberId));
            if (t != null) {
                menu.displayMessage("당신이 선택한 시간은 " + t.getStartTime() + " - " + t.getEndTime() + " 입니다.");
            }else{
                menu.displayMessage("데이터 없음");
            }
        } catch (TimeException e) {
            e.printStackTrace();
            menu.displayMessage("조회에 실패했습니다.");
        }
    }
}
