package vakcinisoniclerk.services;

import vakcinisoniclerk.models.VaccinationReports;
import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;

public interface ICertificatesService {

    VaccinationReports getByJmbg(String jmbg);
    String acceptCertificateRequest(String jmbg);
    String declineCertificateRequest(String jmbg, DeclineCertificateRequestDto declineRequest);
}
