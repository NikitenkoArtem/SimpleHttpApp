package local.zone.simpleapp.dao.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Price on 13.10.2016.
 */
public class Transfer implements Serializable {
    private Integer transferId;
    private Date transferDate;
    private String currency;
    private Integer sum;
    private Integer commission;

    public Transfer() {
    }

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", transferDate=" + transferDate +
                ", currency='" + currency + '\'' +
                ", sum=" + sum +
                ", commission=" + commission +
                '}';
    }
}
