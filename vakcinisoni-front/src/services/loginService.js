import { postObject } from "./axiosService";

const PATH = "citizens/login";

export function postLoginObject(account, callback){
    var xmlData = 
    `<credentials xmlns="http://www.vakcinisoni.com">
        <jmbg>${account.username}</jmbg>
        <password>${account.password}</password>
     </credentials>`
     
    postObject(`${PATH}`, xmlData, callback, loginErrorCallback);
}

function loginErrorCallback(error){
    alert("Wrong username/password! " + error);
}