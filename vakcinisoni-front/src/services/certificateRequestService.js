import { getObjects, postObject } from "./axiosService";

const PATH = "certificate-requests";

export function postCertificateRequestObject(request, richReason, callback){
    const today = "2022-02-16";

    var xmlData = `
    <certificateRequest xmlns="http://www.vakcinisoni.com"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.vakcinisoni.com/DigitalCertRequest DigitalCertRequest.xsd"
        xmlns:pred="http://www.vakcinisoni.com/rdf/predicate"
        about="http://www.vakcinisoni.com/DigitalCertRequest/1"
        dateTime="${today}"
        accepted="${false}"
        >
        <fullName property="pred:fullName">${request.fullName}</fullName>
        <birthDate>${request.dateOfBirth}</birthDate>
        <gender>${request.gender}</gender>
        <jmbg property="pred:jmbg">${request.jmbg}</jmbg>
        <passportNum>${request.passportNum}</passportNum>
        <reason>${richReason}</reason>
        <place property="pred:place">${request.place}</place>
        <requestDate>${today}</requestDate>
    </certificateRequest>
    `;

    postObject(`${PATH}/`, xmlData, callback);
}

export function getRequestsForUser(callback){
    let jmbg = "2509999880166";

    getObjects(`${PATH}/${jmbg}`, callback);
}