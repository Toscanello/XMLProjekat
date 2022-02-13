package vakcinisoniclerk.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;
import vakcinisoniclerk.services.contracts.ICertificatesService;

import javax.ws.rs.*;

@Service
@Path("/certificates")
public class CertificatesServiceImpl implements ICertificatesService {

    @GET
    @Path("/{requestId}/accept")
    public String acceptCertificateRequest(@PathParam("requestId") String requestId){
        // TODO: enable certificate to be seen by the citizen

        // TODO: fetch converted (in PDF and XHTML) certificate format and attach it to a mail

        // TODO: send email
        MailerService.sendAcceptedMail("baronidmn@gmail.com", "Svetozar", "asdf");

        return "email sent";
    }

    @POST
    @Path("/{requestId}/decline")
    @Consumes("application/xml")
    public String declineCertificateRequest(@PathParam("requestId") String requestId, DeclineCertificateRequestDto declineRequest) {
        // TODO: delete request doc from database

        // TODO: send email
        MailerService.sendDeclineMail("svetozar.vulin@gmail.com", "Svetozar", declineRequest.getMessage());

        return "email sent";
    }
}
