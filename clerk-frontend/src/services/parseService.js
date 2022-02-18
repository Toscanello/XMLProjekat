import xml2js from "xml2js";

export function parseXmlToJs(xmlString, callback){
    let parser = new xml2js.Parser();
    parser.parseString(xmlString, function(err, result) { 
        callback(result);
    })
}