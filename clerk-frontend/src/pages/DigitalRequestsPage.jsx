import { useEffect, useState } from "react";
import {
  acceptCertificateRequest,
  declineCertificateRequest,
  getCertificateRequests,
} from "../services/digitalCertificatesService";
import { parseXmlToJs } from "../services/parseService";

export const DigitalRequestsPage = () => {
  const [requests, setRequests] = useState([]);
  const [jmbg, setJmbg] = useState("");
  const [declineMessage, setDeclineMessage] = useState("");
  const [isDeclined, setIsDeclined] = useState(false);

  useEffect(() => {
    getCertificateRequests((response) => {
      parseXmlToJs(response.data, (result) => {
        const request = result["certificateRequests"].certificateRequest;
        console.log(request);
        setRequests(request);
      });
    });
  }, []);

  const fetchCertificateRequest = (jmbg) => {};

  const fetchVaccinationReport = (jmbg) => {};

  const acceptRequest = (jmbg) => {
    acceptCertificateRequest(jmbg, window.location.reload());
  };

  const setDecline = (jmbg) => {
    setIsDeclined(true);
    setJmbg(jmbg);
  };

  const declineRequest = () => {
    if (declineMessage !== "") {
      declineCertificateRequest(jmbg, declineMessage, window.location.reload());
      setIsDeclined(false);
      setJmbg("");
    }
  };

  return (
    <>
      {isDeclined ? (
        <>
          <input
            type="text"
            value={declineMessage}
            placeholder="Razlog za odbijanje: "
            onChange={(e) => setDeclineMessage(e.target.value)}
          />
          <button onClick={() => declineRequest()}>Potvrdi</button>
        </>
      ) : null}
      <table>
        <tbody>
          {requests.map((request, i) => {
            return (
              <>
                <tr key={i}>
                  <td>{request.fullName}</td>
                </tr>
                <tr key={request + i}>
                  <td>{request.requestDate}</td>
                </tr>
                <tr>
                  <td>
                    <button
                      onClick={() => fetchCertificateRequest(request.jmbg)}
                    >
                      Pregledaj zahtev za sertifikat
                    </button>
                  </td>
                  <td>
                    <button
                      onClick={() => fetchVaccinationReport(request.jmbg)}
                    >
                      Pregledaj vakcinacije
                    </button>
                  </td>
                  <td>
                    <button
                      onClick={() =>
                        acceptRequest(request.jmbg + "-" + (i + 1))
                      }
                    >
                      Odobri zahtev
                    </button>
                  </td>
                  <td>
                    <button
                      onClick={() => setDecline(request.jmbg + "-" + (i + 1))}
                    >
                      Odbij zahtev
                    </button>
                  </td>
                </tr>
              </>
            );
          })}
        </tbody>
      </table>
    </>
  );
};
