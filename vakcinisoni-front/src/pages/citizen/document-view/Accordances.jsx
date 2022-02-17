import { useState, useEffect } from "react";
import { getAccordancesForUser } from "../../../services/accordanceService";
import { downloadPdf, downloadHtml } from "../../../services/axiosService";
import { parseXmlToJs } from "../../../services/parseService";

const HTTP_SERVER_PATH = "http://172.20.176.1:8081/";

function Accordances(){

    const[accordances, setAccordances] = useState([]);

    useEffect(() => {
        getAccordancesForUser((response) => {
            parseXmlToJs(response.data, (result) => {
                console.log(result.accordances.accordance);
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
        console.log("POZVANA FUNKCIJAAA")
        downloadHtml("accordances", e.target.id, (response)=>{
            if(response.status === 200){
                console.log(response.data);
                window.open(`${HTTP_SERVER_PATH}ImmunizationAccordance.html`);
            }
        })
    }
    function handlePreview(e){
        console.log(e);

    }
    return(
        <>
            {accordances.map(accordance => {
                return <div>
                    <h2>{accordance.jmbg + "_" + accordance.date}</h2>
                    <button onClick={handleSavePdf} id={accordance.jmbg + "_" + accordance.date}>Sacuvaj PDF</button>
                    <button onClick={handleSaveHtml} id={accordance.jmbg + "_" + accordance.date}>Sacuvaj XHTML</button><br/>
                    <button onClick={handlePreview}>Pregledaj</button>
                </div>
            })}
        </>
    );

}
export default Accordances;