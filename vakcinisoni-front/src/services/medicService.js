import { postObject } from "./axiosService";

const PATH = "immunization/accordance";

export function postVaccineEvidenceInAccordance(vaccineEvidence, callback){

    // var xmlData = `<vaccineEvidence xmlns="http://www.vakcinisoni.com"
    //     <institution property="pred:institution">DZ SM</institution>
    //     <vaccinationNum>1100</vaccinationNum>
    //     <doctorInfo>
    //         <fullName>Mika Mikic</fullName>
    //         <fax>12312312321</fax>
    //         <phoneNum>022 464 373</phoneNum>
    //     </doctorInfo>
    //     <table>
    //         <row>
    //             <vaccineName>Kinez</vaccineName>
    //             <dateIssued>2021-11-05</dateIssued>
    //             <issueMethod>0</issueMethod>
    //             <bodyPart>0</bodyPart>
    //             <batch>11161</batch>
    //             <manufacturer>BIOTECH</manufacturer>
    //             <reaction></reaction>
    //         </row>
    //     </table>
    // </vaccineEvidence>`
    var xmlData = `
        <vaccineEvidence xmlns="http://www.vakcinisoni.com">
            <institution property="pred:institution">${vaccineEvidence.institution}</institution>
            <vaccinationNum>${vaccineEvidence.vaccinationNum}</vaccinationNum>
            <doctorInfo>
                <fullName>${vaccineEvidence.fullName}</fullName>
                <fax>${vaccineEvidence.fax}</fax>
                <phoneNum>${vaccineEvidence.phoneNum}</phoneNum>
            </doctorInfo>
            <table>
                <row>
                    <vaccineName>${vaccineEvidence.vaccineName}</vaccineName>
                    <dateIssued>${vaccineEvidence.dateIssued}</dateIssued>
                    <issueMethod>${vaccineEvidence.issueMethod}</issueMethod>
                    <bodyPart>${vaccineEvidence.bodyPart}</bodyPart>
                    <batch>${vaccineEvidence.batch}</batch>
                    <manufacturer>${vaccineEvidence.manufacturer}</manufacturer>
                    <reaction>${vaccineEvidence.reaction}</reaction>
                </row>
            </table>
        </vaccineEvidence>
    `;
    postObject(`${PATH}/${vaccineEvidence.jmbg}`, xmlData, callback);
}

