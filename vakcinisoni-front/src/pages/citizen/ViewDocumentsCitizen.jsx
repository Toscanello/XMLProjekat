import { useState } from "react";
import { Link } from "react-router-dom";
function ViewDocumentsCitizen(){

    const[jmbg, setJmbg] = useState('2509999880166');

    return(
        <nav>
            <ul className="nav" id="navbar">
                <li><Link to={`accordances`}>Saglasnosti</Link><br/></li>
                <li><Link to={`candidates`}>Interesovanja</Link><br/></li>
                <li><Link to={`certificate-requests`}>Zahtevi za sertifikat</Link><br/></li>
                <li><Link to={`certificate`}>Zeleni Sertifikat</Link><br/></li>
            </ul>
            
        </nav>
    );

}

export default ViewDocumentsCitizen;