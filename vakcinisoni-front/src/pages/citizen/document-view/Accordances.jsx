import { useState, useEffect } from "react";
import { getAccordancesForUser } from "../../../services/accordanceService";
import { downloadPdf, downloadHtml } from "../../../services/axiosService";
import { parseXmlToJs } from "../../../services/parseService";
import { HTTP_SERVER_PATH } from "../../../utils/constants";

function Accordances(){

    const[accordances, setAccordances] = useState([]);

    useEffect(() => {
        getAccordancesForUser((response) => {
            console.log(response.data);
            parseXmlToJs(response.data.replaceAll('ns3:', ''), (result) => {
                console.log(result);
                setAccordances(result.accordances.accordance);
            });
        });
    }, []);

    function handleSavePdf(e){
        e.preventDefault();
        console.log(e.target.id);
        downloadPdf("accordances", e.target.id, (response) => {
            if(response.status === 200){
                console.log("SHOW PATH TO DOWNLOADED FILE")
            }
        })
    }

    function handleSaveHtml(e){
        e.preventDefault();
        console.log(e.target.id);
        downloadHtml("accordances", e.target.id, (response)=>{
            if(response.status === 200){
                console.log(response.data);
                window.open(`${HTTP_SERVER_PATH}${response.data}`);
            }
        })
    }

    return(
        <>
            {accordances.map(accordance => {
                return <div>
                    <h2>{accordance.jmbg + "_" + accordance.date}</h2>
                    <button onClick={handleSavePdf} id={accordance.jmbg + "_" + accordance.date}>Sacuvaj PDF</button>
                    <button onClick={handleSaveHtml} id={accordance.jmbg + "_" + accordance.date}>Sacuvaj XHTML</button><br/>
                </div>
            })}
        </>
    );

}
export default Accordances;