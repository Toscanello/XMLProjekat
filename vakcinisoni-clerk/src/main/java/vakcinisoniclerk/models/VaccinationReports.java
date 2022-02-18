package vakcinisoniclerk.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "vaccinationReports")
public class VaccinationReports {

    private List<VaccinationReport> vaccinationReport;

    public VaccinationReports() { }

    public VaccinationReports(List<VaccinationReport> vaccinationReport) { this.vaccinationReport = vaccinationReport; }

    public List<VaccinationReport> getVaccinationReport() {
        return vaccinationReport;
    }

    public void setVaccinationReport(List<VaccinationReport> vaccinationReport) {
        this.vaccinationReport = vaccinationReport;
    }

    @Override
    public String toString() {
        return "VaccinationReports{" +
                "vaccinationReport=" + vaccinationReport +
                '}';
    }
}
