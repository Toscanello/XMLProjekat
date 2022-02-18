package vakcinisoniclerk.repository.impl;

import org.springframework.stereotype.Repository;
import vakcinisoniclerk.models.ImmunizationReport;

import java.io.IOException;

@Repository
public class ImmunizationReportRepository extends CrudRepository<ImmunizationReport> {
    private static final String IMMUNIZATION_ACCORDANCE_COLLECTION_NAME = "immunization-report";
    public ImmunizationReportRepository() throws IOException {
        super(IMMUNIZATION_ACCORDANCE_COLLECTION_NAME);
    }

}
