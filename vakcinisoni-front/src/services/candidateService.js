import { postObject, getObjects } from "./axiosService"

const PATH = "candidates";

export function postCandidateObject(candidate, callback){
    const today = "2022-02-16";

    var xmlData = `
    <vaccineCandidate xmlns="http://www.vakcinisoni.com"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.vakcinisoni.com/VaccineCandidate VaccineCandidate.xsd"
        xmlns:pred="http://www.vakcinisoni.com/rdf/predicate"
        about="http://www.vakcinisoni.com/VaccineCandidate/${candidate.jmbg}">
        <residence>0</residence>
        <jmbg property="pred:jmbg">${candidate.jmbg}</jmbg>
        <name property="pred:name">${candidate.name}</name>
        <surname property="pred:surname">${candidate.surname}</surname>
        <email>${candidate.email}</email>
        <phoneNum>${candidate.phoneNum}</phoneNum>
        <homeNum>${candidate.homeNum}</homeNum>
        <location property="pred:location">${candidate.location}</location>
        <options>
            ${candidate.options.map(opt => {
                return `<manufacturer>${opt}</manufacturer>`
            })}
        </options>
        <isBloodDonor>${candidate.bloodDonor}</isBloodDonor>
        <date>${today}</date>
    </vaccineCandidate>
    `;
    xmlData = xmlData.replaceAll(',', '');
    postObject(`${PATH}/`, xmlData, callback);
}

export function getCandidatesForUser(callback){
    let jmbg = localStorage.getItem('jmbg');

    getObjects(`${PATH}/filter/${jmbg}`, callback);
}