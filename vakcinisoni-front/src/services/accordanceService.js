import { getObjects, postObject } from "./axiosService";

const PATH = "accordances";

export function postAccordanceObject(accordance, callback){
    const today = "2022-02-16";

    var xmlData = `
    <accordance xmlns="http://www.vakcinisoni.com"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.vakcinisoni.com/ImmunizationAccordance ImmunizationAccordance.xsd"
        xmlns:pred="http://www.vakcinisoni.com/rdf/predicate"
        about="http://www.vakcinisoni.com/ImmunizationAccordance/1">
        <jmbg property="pred:jmbg">${accordance.jmbg}</jmbg>
        <surname property="pred:surname">${accordance.surname}</surname>
        <name property="pred:name">${accordance.name}</name>
        <parentName>${accordance.parentName}</parentName>
        <gender>${accordance.gender}</gender>
        <birthDate>${accordance.birthDate}</birthDate>
        <birthPlace>${accordance.birthPlace}</birthPlace>
        <address>${accordance.address}</address>
        <post>${accordance.post}</post>
        <city property="pred:city">${accordance.city}</city>
        <homeNumber>${accordance.homeNumber}</homeNumber>
        <phoneNum>${accordance.phoneNum}</phoneNum>
        <email>${accordance.email}</email>
        <workStatus>${accordance.workStatus}</workStatus>
        <employedAt>${accordance.employedAt}</employedAt>
        <socialSecurity>${accordance.socialSecurity}</socialSecurity>
        <residenceName>${accordance.residenceName}</residenceName>
        <isAccordant>${accordance.isAccordant}</isAccordant>
        <medicineName>${accordance.medicineName}</medicineName>
        <date>${today}</date>
    </accordance>
    `;
    
    postObject(`${PATH}/`, xmlData, callback);
}

export function getAccordancesForUser(callback){
    let jmbg = "2509999880166";

    getObjects(`${PATH}/${jmbg}`, callback);
}