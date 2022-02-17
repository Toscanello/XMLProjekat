import { getObjects } from "./axiosService";

const PATH = "certificates";

export function getCertificatesForUser(callback){
    let jmbg = "0710999850006";

    getObjects(`${PATH}/read/${jmbg}`, callback);
}