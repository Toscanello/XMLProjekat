package vakcinisoniclerk.models;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "dose"
})
@XmlRootElement(name = "vaccination")
public class Vaccination {

    @XmlElement(required = true)
    protected List<Dose> dose;

    public Vaccination() {}

    public Vaccination(List<Dose> dose) {
        this.dose = dose;
    }

    public List<Dose> getDose() {
        return dose;
    }

    public void setDose(List<Dose> dose) {
        this.dose = dose;
    }
}
