package vakcinisoniclerk.services;

import org.springframework.stereotype.Service;
import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;
import vakcinisoniclerk.services.contracts.ICertificatesService;

@Service
public class CertificatesServiceImpl implements ICertificatesService {

    public String acceptCertificateRequest(String requestId){
        // TODO: enable certificate to be seen by the citizen

        // TODO: fetch converted (in PDF and XHTML) certificate format and attach it to a mail

        // TODO: send email
        MailerService.sendAcceptedMail("baronidmn@gmail.com", "Svetozar", "asdf");

        return "email sent";
    }

    public String declineCertificateRequest(String requestId, DeclineCertificateRequestDto declineRequest) {
        // TODO: delete request doc from database

        // TODO: send email
        MailerService.sendDeclineMail("svetozar.vulin@gmail.com", "Svetozar", declineRequest.getMessage());

        return "email sent";
    }
}
