import { postObject } from "./axiosService";

const PATH = "citizens";

export function postLoginObject(account, callback){
    var xmlData = 
    `<credentials xmlns="http://www.vakcinisoni.com">
        <jmbg>${account.username}</jmbg>
        <password>${account.password}</password>
     </credentials>`

    postObject(`${PATH}/login`, xmlData, callback, loginErrorCallback);
}

export function postRegisterObject(citizen, callback){
    var xmlData = `
        <citizen xmlns="http://www.vakcinisoni.com">
            <name>${citizen.name}</name>
            <surname>${citizen.surname}</surname>
            <gender>${citizen.gender}</gender>
            <dateOfBirth>${citizen.dateOfBirth}</dateOfBirth>
            <jmbg>${citizen.jmbg}</jmbg>
            <passportNum>${citizen.passportNum}</passportNum>
            <email>${citizen.email}</email>
            <password>${citizen.password}</password>
        </citizen>
    `
    postObject(`${PATH}/register`, xmlData, callback);
}

function loginErrorCallback(error){
    alert("Wrong username/password! " + error);
}