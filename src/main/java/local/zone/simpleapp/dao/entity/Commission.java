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
    @XmlElement(required = true)
    private String brand;
    @XmlElement(required = true)
    private String currency;
    @XmlElement(required = true)
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
                ", currency=" + currency +
                ", value=" + value +
                '}';
    }
}