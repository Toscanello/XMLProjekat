import { useState, useEffect } from "react";
import { parseXmlToJs } from "../../../services/parseService";
import { HTTP_SERVER_PATH } from "../../../utils/constants";
import { downloadPdf, downloadHtml } from "../../../services/axiosService";
import { getRequestsForUser } from "../../../services/certificateRequestService";


function Requests(){
    const[requests, setRequests] = useState([]);

    var count = 0;

    useEffect(() => {
        getRequestsForUser((response) => {
            parseXmlToJs(response.data.replaceAll('ns3:', ''), (result) => {
                console.log(result);
                console.log(result.certificateRequests.certificateRequest);
                setRequests(result.certificateRequests.certificateRequest);
            })            
        })
    }, []);

    function handleSavePdf(e){
        e.preventDefault();
        console.log(e.target.id);
        downloadPdf("certificate-requests", e.target.id, (response) => {
            if(response.status === 200){
                console.log("SHOW PATH TO DOWNLOADED FILE")
            }
        })
    }

    function handleSaveHtml(e){
        e.preventDefault();
        console.log(e.target.id);
        console.log("POZVANA FUNKCIJAAA")
        downloadHtml("certificate-requests", e.target.id, (response)=>{
            if(response.status === 200){
                console.log(response.data);
                window.open(`${HTTP_SERVER_PATH}${response.data}`);
            }
        })
    }

    return(
        <>
            {requests.map(request => {
                return <div>
                    <h2>{request.jmbg + "-" + (++count)}</h2>
                    <button onClick={handleSavePdf} id={request.jmbg + "-" + count}>Sacuvaj PDF</button>
                    <button onClick={handleSaveHtml} id={request.jmbg + "-" + count}>Sacuvaj XHTML</button><br/>
                </div>
            })}
        </>
    );

}
export default Requests;