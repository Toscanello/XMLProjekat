package vakcinisoniclerk.services;

import vakcinisoniclerk.models.DigitalCertificateRequests;
import vakcinisoniclerk.models.VaccinationReports;
import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;

public interface ICertificatesService {

    VaccinationReports getByJmbg(String jmbg);
    DigitalCertificateRequests getRequests();
    String acceptCertificateRequest(String jmbg);
    String declineCertificateRequest(String jmbg, DeclineCertificateRequestDto declineRequest);
}
