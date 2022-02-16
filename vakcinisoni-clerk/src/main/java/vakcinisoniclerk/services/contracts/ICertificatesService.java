package vakcinisoniclerk.services.contracts;

import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;

public interface ICertificatesService {

    String acceptCertificateRequest(String requestId);
    String declineCertificateRequest(String requestId, DeclineCertificateRequestDto declineRequest);
}
