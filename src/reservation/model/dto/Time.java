package reservation.model.dto;

import java.io.Serializable;

public class Time implements Serializable {

    private static final long serialVersionUID = 123456789L;

    private String timeCode;
    private String startTime;
    private String endTime;

    public Time() {}

    public Time(String timeCode, String startTime, String endTime) {
        this.timeCode = timeCode;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(String timeCode) {
        this.timeCode = timeCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Time{" +
                "timeCode='" + timeCode + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
