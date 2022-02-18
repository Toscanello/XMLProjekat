import { useState, useEffect } from "react";
import { getCandidatesForUser } from "../../../services/candidateService";
import { downloadPdf, downloadHtml } from "../../../services/axiosService";
import { parseXmlToJs } from "../../../services/parseService";
import { HTTP_SERVER_PATH } from "../../../utils/constants";

function Candidates(){

    const[candidates, setCandidates] = useState([]);

    useEffect(() => {
        getCandidatesForUser((response) => {
            parseXmlToJs(response.data.replaceAll('ns2:', ''), (result) => {
                console.log(result.vaccineCandidates.vaccineCandidate);
                setCandidates(result.vaccineCandidates.vaccineCandidate);
            })
        })
    },[]);

    function handleSavePdf(e){
        e.preventDefault();
        console.log(e.target.id);
        downloadPdf("candidates", e.target.id, (response) => {
            if(response.status === 200){
                console.log("SHOW PATH TO DOWNLOADED FILE")
            }
        })
    }

    function handleSaveHtml(e){
        e.preventDefault();
        console.log(e.target.id);
        downloadHtml("candidates", e.target.id, (response)=>{
            if(response.status === 200){
                console.log(response.data);
                window.open(`${HTTP_SERVER_PATH}${response.data}`);
            }
        })
    }

    return(
        <>
            {
                candidates.map(candidate => {
                    return <div>
                            <h2>{candidate.id}</h2>
                            <button onClick={handleSavePdf} id={candidate.id}>Sacuvaj PDF</button>
                            <button onClick={handleSaveHtml} id={candidate.id}>Sacuvaj HTML</button>
                           </div>
                })
            }
        </>
    );
}
export default Candidates;