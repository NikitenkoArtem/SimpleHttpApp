package local.zone.simpleapp.dao.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by Price on 13.10.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Commission implements Serializable {
    @XmlAttribute(name = "id")
    private Integer commissionId;
    @XmlElement
    private String brand;
    @XmlElement(name = "currency", type = Currency.class)
    private Currency currencyId;
    @XmlElement
    private Float value;

    public Commission() {
    }

    public Integer getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Integer commissionId) {
        this.commissionId = commissionId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Currency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currency currencyId) {
        this.currencyId = currencyId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Commission{" +
                "commissionId=" + commissionId +
                ", brand='" + brand + '\'' +
                ", currencyId=" + currencyId +
                ", value=" + value +
                '}';
    }
}