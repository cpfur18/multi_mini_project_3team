package reservation.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Resveration implements Serializable {
    private String rsvMemberMo;
    private String rsvSeatCode;
    private String rsvTimeCode;
    private String rsvProductNo;
    private int rsvTotalPrice;
    private Date updDate;
    private Date delDate;

    public Resveration() {
        // TODO Auto-generated constructor stub
    }

    public Resveration(String rsvMemberMo, String rsvSeatCode, String rsvTimeCode, String rsvProductNo, int rsvTotalPrice, Date updDate, Date delDate) {
        this.rsvMemberMo = rsvMemberMo;
        this.rsvSeatCode = rsvSeatCode;
        this.rsvTimeCode = rsvTimeCode;
        this.rsvProductNo = rsvProductNo;
        this.rsvTotalPrice = rsvTotalPrice;
        this.updDate = updDate;
        this.delDate = delDate;
    }

    public String getRsvMemberMo() {
        return rsvMemberMo;
    }

    public void setRsvMemberMo(String rsvMemberMo) {
        this.rsvMemberMo = rsvMemberMo;
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

    public String getRsvProductNo() {
        return rsvProductNo;
    }

    public void setRsvProductNo(String rsvProductNo) {
        this.rsvProductNo = rsvProductNo;
    }

    public int getRsvTotalPrice() {
        return rsvTotalPrice;
    }

    public void setRsvTotalPrice(int rsvTotalPrice) {
        this.rsvTotalPrice = rsvTotalPrice;
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
                "rsvMemberMo='" + rsvMemberMo + '\'' +
                ", rsvSeatCode='" + rsvSeatCode + '\'' +
                ", rsvTimeCode='" + rsvTimeCode + '\'' +
                ", rsvProductNo='" + rsvProductNo + '\'' +
                ", rsvTotalPrice=" + rsvTotalPrice +
                ", updDate=" + updDate +
                ", delDate=" + delDate +
                '}';
    }
}
