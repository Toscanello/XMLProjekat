package vakcinisoniclerk.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="reports")
public class Reports {

    private List<ImmunizationReport> report;

    public Reports() {}

    public Reports(List<ImmunizationReport> report) {
        this.report = report;
    }

    public List<ImmunizationReport> getReport() {
        return report;
    }

    public void setReport(List<ImmunizationReport> report) {
        this.report = report;
    }
}
