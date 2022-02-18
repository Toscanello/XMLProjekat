package vakcinisoniclerk.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="accordances")
public class Accordances {
    private List<ImmunizationAccordance> accordance;

    public Accordances() {}

    public Accordances(List<ImmunizationAccordance> accordance) { this.accordance = accordance; }

    public List<ImmunizationAccordance> getAccordance() {
        return accordance;
    }

    public void setAccordance(List<ImmunizationAccordance> accordance) {
        this.accordance = accordance;
    }

    @Override
    public String toString() {
        return "Accordances{" +
                "accordance=" + accordance +
                '}';
    }
}
