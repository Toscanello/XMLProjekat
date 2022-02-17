import { useState, useEffect } from "react";
import { getAccordancesForUser } from "../../../services/accordanceService";
import { downloadPdf } from "../../../services/axiosService";
import { parseXmlToJs } from "../../../services/parseService";

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

    return(
        <>
            {accordances.map(accordance => {
                return <div>
                    <h2>{accordance.jmbg + "_" + accordance.date}</h2>
                    <button onClick={handleSavePdf} id={accordance.jmbg + "_" + accordance.date}>Sacuvaj PDF</button>
                    <button>Sacuvaj XHTML</button><br/>
                    <button>Pregledaj</button>
                </div>
            })}
        </>
    );

}
export default Accordances;