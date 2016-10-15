package local.zone.simpleapp.dao.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Price on 13.10.2016.
 */
public class Transfer implements Serializable {
    private Integer transferId;
    private Date transferDate;
    private Double sum;
    private Commission commissionId;

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

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Commission getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Commission commissionId) {
        this.commissionId = commissionId;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", transferDate=" + transferDate +
                ", sum=" + sum +
                ", commissionId=" + commissionId +
                '}';
    }
}
