package local.zone.simpleapp.dao.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Price on 13.10.2016.
 */
public class Transfer implements Serializable {
    private Integer transferId;
    private Date transferDate;
    private Currency currencyId;
    private Integer sum;
    private Integer commissionId;

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

    public Currency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currency currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Integer commissionId) {
        this.commissionId = commissionId;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", transferDate=" + transferDate +
                ", currencyId='" + currencyId + '\'' +
                ", sum=" + sum +
                ", commissionId=" + commissionId +
                '}';
    }
}
