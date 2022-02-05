package vakcinisoniclerk.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "vaccines")
public class Vaccines {

    private List<Vaccine> vaccine;

    public Vaccines() {}

    public Vaccines(List<Vaccine> vaccine) {
        this.vaccine = vaccine;
    }

    public List<Vaccine> getVaccine() {
        return vaccine;
    }

    public void setVaccine(List<Vaccine> vaccine) {
        this.vaccine = vaccine;
    }
}
