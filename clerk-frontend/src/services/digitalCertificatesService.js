import { getObjects, postObject } from "./axiosService";

const PATH = "certificates";

export const getCertificateRequests = (callback) => {
  return getObjects(`${PATH}/fetchRequests`, callback);
};

export const acceptCertificateRequest = (jmbg, callback) => {
  return getObjects(`${PATH}/${jmbg}/accept`, callback);
};

export const declineCertificateRequest = (jmbg, declineMessage, callback) => {
  const xmlData = `
    <certificate-declined>
      <declineMessage>
          ${declineMessage}
      </declineMessage>
    </certificate-declined>
  `;
  return postObject(`${PATH}/${jmbg}/decline`, xmlData, callback);
};
