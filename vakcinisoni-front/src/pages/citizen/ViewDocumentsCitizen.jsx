import { useState } from "react";
import { Link } from "react-router-dom";
function ViewDocumentsCitizen(){

    const[jmbg, setJmbg] = useState('2509999880166');

    return(
        <>
            <Link to={`accordances`}>Saglasnosti</Link><br/>
            <Link to={`candidates`}>Interesovanja</Link><br/>
            <Link to={`certificate-requests`}>Zahtevi za sertifikat</Link><br/>
            <Link to={`certificate`}>Zeleni Sertifikat</Link><br/>
        </>
    );

}

export default ViewDocumentsCitizen;