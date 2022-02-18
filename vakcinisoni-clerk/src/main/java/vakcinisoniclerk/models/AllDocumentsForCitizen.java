package vakcinisoniclerk.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="allDocuments")
public class AllDocumentsForCitizen {

    private Accordances accordances;

    private DigitalCertificates digitalCertificates;

    private VaccinationReports vaccinationReports;



    public Accordances getAccordances() {
        return accordances;
    }

    public void setAccordances(Accordances accordances) {
        this.accordances = accordances;
    }

    public DigitalCertificates getDigitalCertificates() {
        return digitalCertificates;
    }

    public void setDigitalCertificates(DigitalCertificates digitalCertificates) {
        this.digitalCertificates = digitalCertificates;
    }

    public VaccinationReports getVaccinationReports() {
        return vaccinationReports;
    }

    public void setVaccinationReports(VaccinationReports vaccinationReports) {
        this.vaccinationReports = vaccinationReports;
    }
}
