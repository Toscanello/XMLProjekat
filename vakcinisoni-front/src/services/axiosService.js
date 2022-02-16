import axios from 'axios';
import xml2js from "xml2js";

const API_URL = "http://localhost:3000";
//const qs = require('querystring');

export function getObjects(path, callback=defaultCallback, errorCallback=defaultErrorCallback){
    axios
    .get(`${API_URL}/${path}`, {"Content-Type": "application/xml; charset=utf-8"})
    .then(response => {
        callback(response);
    })
    .catch(error => {
        errorCallback(error);
    });
}

export function getObjectById(path, id, callback=defaultCallback, errorCallback=defaultErrorCallback){
    axios
    .get(`${API_URL}/${path}/${id}`, {"Content-Type": "application/xml; charset=utf-8"})
    .then(response => {
        callback(response);
    })
    .catch(error => {
        errorCallback(error)
    });
}

export function postObject(path, xmlData, callback=defaultCallback, errorCallback=defaultErrorCallback){
    axios
    .post(`${API_URL}/${path}`, xmlData, {headers: {'Content-Type' : 'application/xml'}})
    .then(response => {
        let parser = new xml2js.Parser();

        parser.parseString(response.data, function(err, result) { 
            console.log(result);
        })

        callback(response);
    })
    .catch(error => {
        errorCallback(error);
    });
}

export function putObject(path, object, callback=defaultCallback, errorCallback=defaultErrorCallback){
    axios
    .put(`${API_URL}/${path}`, object)
    .then(response => {
        callback(response);
    })
    .catch(error => {
        errorCallback(error);
    });
}

export function deleteObject(path, objectId, callback=defaultCallback, errorCallback=defaultErrorCallback){
    axios
    .delete(`${API_URL}/${path}/?id=${objectId}`, {"Content-Type" : "application/xml"})
    .then(response => {
        callback(response);
    })
    .catch(error => {
        errorCallback(error);
    });
}

function defaultCallback(response){
    if(response.status === 200){
        console.log("OK");
    }
    else if(response.status === 201){
        console.log("CREATED");
    }
    else if(response.status === 204){
        console.log("NO CONTENT");
    }
    else if(response.status === 400){
        console.log("BAD REQUEST");
    }
    else if(response.status === 401){
        console.log("UNAUTHORIZED");
    }
    else if(response.status === 404){
        console.log("NOT FOUND");
    }
    else if(response.status === 500){
        console.log("SERVER ERROR");
    }
    else{
        console.log(response.status);
    }
}

function defaultErrorCallback(error){
    console.log(error);
}