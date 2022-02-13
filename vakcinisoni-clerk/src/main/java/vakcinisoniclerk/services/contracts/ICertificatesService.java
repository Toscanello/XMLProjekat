package vakcinisoniclerk.services.contracts;

import org.springframework.web.bind.annotation.RequestBody;
import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;

import javax.websocket.server.PathParam;

public interface ICertificatesService {

    String declineCertificateRequest(@PathParam("requestId") String requestId,
                                     @RequestBody DeclineCertificateRequestDto declineRequest);
}
