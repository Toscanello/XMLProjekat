import { useEffect, useState } from "react";
import { downloadHtml } from "../services/axiosService";
import {
  acceptCertificateRequest,
  declineCertificateRequest,
  getCertificateRequests,
} from "../services/digitalCertificatesService";
import { parseXmlToJs } from "../services/parseService";
import { SERVER_URL } from "../utils/constants";

export const DigitalRequestsPage = () => {
  const [requests, setRequests] = useState([]);
  const [jmbg, setJmbg] = useState("");
  const [declineMessage, setDeclineMessage] = useState("");
  const [isDeclined, setIsDeclined] = useState(false);

  useEffect(() => {
    getCertificateRequests((response) => {
      parseXmlToJs(response.data, (result) => {
        const request = result["certificateRequests"].certificateRequest;
        setRequests(request);
      });
    });
  }, []);

  const fetchCertificateRequest = (e) => {
    const certId = e.target.id;
    downloadHtml("certificate-requests", certId, (response) => {
      if (response.status === 200) {
        window.open(`${SERVER_URL}/${response.data}`);
      }
    });
  };

  const fetchVaccinationReport = (e) => {
    downloadHtml("vaccine-reports", e.target.id, (response) => {
      if (response.status === 200) {
        window.open(`${SERVER_URL}/${response.data}`);
      }
    });
  };

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
      <h1>Zahtevi za izdavanje digitalnog sertifikata</h1>
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
          {requests ? (
            requests.map((request, i) => {
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
                        id={request.jmbg + "-" + (i + 1)}
                        onClick={(e) => fetchCertificateRequest(e)}
                      >
                        Pregledaj zahtev za sertifikat
                      </button>
                    </td>
                    <td>
                      <button
                        id={i + 1}
                        onClick={(e) => fetchVaccinationReport(e)}
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
            })
          ) : (
            <h4>Trenutno nema zahteva za digitalni sertifikat</h4>
          )}
        </tbody>
      </table>
    </>
  );
};
