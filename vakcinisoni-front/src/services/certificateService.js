import { getObjects } from "./axiosService";

const PATH = "certificates";

export function getCertificatesForUser(callback){
    let jmbg = localStorage.getItem('jmbg');

    getObjects(`${PATH}/read/${jmbg}`, callback);
}