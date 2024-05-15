package reservation.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Resveration implements Serializable {

    private static final long serialVersionUID = 123456789L;
    private int rsvNo;
    private int rsvMemberNo;
    private String rsvSeatCode;
    private String rsvTimeCode;
    private double rsvTotalPrice;
    private Date registDate;
    private Date updDate;
    private Date delDate;

    public Resveration() {}

    public Resveration(int rsvNo, int rsvMemberNo, String rsvSeatCode, String rsvTimeCode, double rsvTotalPrice, Date registDate, Date updDate, Date delDate) {
        this.rsvNo = rsvNo;
        this.rsvMemberNo = rsvMemberNo;
        this.rsvSeatCode = rsvSeatCode;
        this.rsvTimeCode = rsvTimeCode;
        this.rsvTotalPrice = rsvTotalPrice;
        this.registDate = registDate;
        this.updDate = updDate;
        this.delDate = delDate;
    }

    public int getRsvNo() {
        return rsvNo;
    }

    public void setRsvNo(int rsvNo) {
        this.rsvNo = rsvNo;
    }

    public int getRsvMemberNo() {
        return rsvMemberNo;
    }

    public void setRsvMemberNo(int rsvMemberNo) {
        this.rsvMemberNo = rsvMemberNo;
    }

    public String getRsvSeatCode() {
        return rsvSeatCode;
    }

    public void setRsvSeatCode(String rsvSeatCode) {
        this.rsvSeatCode = rsvSeatCode;
    }

    public String getRsvTimeCode() {
        return rsvTimeCode;
    }

    public void setRsvTimeCode(String rsvTimeCode) {
        this.rsvTimeCode = rsvTimeCode;
    }

    public double getRsvTotalPrice() {
        return rsvTotalPrice;
    }

    public void setRsvTotalPrice(double rsvTotalPrice) {
        this.rsvTotalPrice = rsvTotalPrice;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    @Override
    public String toString() {
        return "Resveration{" +
                "rsvNo=" + rsvNo +
                ", rsvMemberNo=" + rsvMemberNo +
                ", rsvSeatCode='" + rsvSeatCode + '\'' +
                ", rsvTimeCode='" + rsvTimeCode + '\'' +
                ", rsvTotalPrice=" + rsvTotalPrice +
                ", registDate=" + registDate +
                ", updDate=" + updDate +
                ", delDate=" + delDate +
                '}';
    }
}
