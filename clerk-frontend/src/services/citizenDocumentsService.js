import { getObjects } from "./axiosService";


const PATH = `clerk/simple-search`;

export function getAllDocumentsForPhrase(phrase, callback){
    getObjects(`${PATH}/${phrase}`, callback);
}