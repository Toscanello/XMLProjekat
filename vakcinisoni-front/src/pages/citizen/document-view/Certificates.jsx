import { useState, useEffect } from "react";
import { downloadPdf, downloadHtml } from "../../../services/axiosService";
import { parseXmlToJs } from "../../../services/parseService";
import { HTTP_SERVER_PATH } from "../../../utils/constants";
import { getCertificatesForUser } from "../../../services/certificateService";

function Certificates(){
    
    const[certificates, setCertificates] = useState([]);

    useEffect(() => {
        getCertificatesForUser((response) => {
            parseXmlToJs(response.data.replaceAll('ns2:',''), (result) => {
                console.log(result);
                setCertificates(result.certificates.certificate);
            });
        });
    }, []);

    function handleSavePdf(e){
        e.preventDefault();
        console.log(e.target.id);
        downloadPdf("certificates", e.target.id, (response) => {
            if(response.status === 200){
                console.log("SHOW PATH TO DOWNLOADED FILE")
            }
        })
    }


    function handleSaveHtml(e){
        e.preventDefault();
        console.log(e.target.id);
        downloadHtml("certificates", e.target.id, (response)=>{
            if(response.status === 200){
                console.log(response.data);
                window.open(`${HTTP_SERVER_PATH}${response.data}`);
            }
        })
    }

    return(
        <>
            {
                certificates.map(certificate => {
                    return <div>
                        <h2>{certificate.id}</h2>
                        <button onClick={handleSavePdf} id = {certificate.id}>Sacuvaj PDF</button>
                        <button onClick={handleSaveHtml} id = {certificate.id}>Sacuvaj HTML</button>
                    </div>
                })
            }
            
        </>
    );
}

export default Certificates;