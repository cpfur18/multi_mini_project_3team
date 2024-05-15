package reservation.model.dto;

import java.io.Serializable;

public class Seat implements Serializable {

    private static final long serialVersionUID = 123456789L;

    private String seatCode;
    private String seatStatus;

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    @Override
    public String toString() {
        return "seat{" +
                "seatCode='" + seatCode + '\'' +
                ", seatStatus='" + seatStatus + '\'' +
                '}';
    }

    public Seat() {}
}