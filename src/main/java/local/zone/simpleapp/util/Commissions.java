package local.zone.simpleapp.util;

import local.zone.simpleapp.dao.entity.Commission;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Price on 13.10.2016.
 */
@XmlRootElement(name = "commissions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Commissions {
    @XmlElement(name = "commission")
    private List<Commission> commissions = new ArrayList<>();

    public List<Commission> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<Commission> commissions) {
        this.commissions = commissions;
    }
}
