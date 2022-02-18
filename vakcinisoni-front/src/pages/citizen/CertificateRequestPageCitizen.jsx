import { useState } from "react";
import { postCertificateRequestObject } from "../../services/certificateRequestService";
import { parseXmlToJs } from "../../services/parseService";
import NavigationHeader from "../../components/header/NavigationHeader";

function CertificateRequestPageCitizen(){

    const[certificateRequest, setCertificateRequest] = useState({
        fullName: localStorage.getItem('name') + " " + localStorage.getItem('surname'),
        dateOfBirth: localStorage.getItem('dateOfBirth'),
        gender: 0,
        jmbg: localStorage.getItem('jmbg'),
        passportNum: localStorage.getItem('passportNum'), // AUTOCOMPLETE?
        reason: "" //RICH EDIT?
    });
    
    function handleSubmit(e){
        e.preventDefault();
        console.log(certificateRequest);
        postCertificateRequestObject(certificateRequest, (response) => {
            console.log(response.data);
            if(response.status === 200){
                alert("Uspesno podnet zahtev!");
            }
        })
    }

    return(
    <>
        <NavigationHeader />
        <div className="for-container">
        
        <h2>Zahtev za Sertifikat</h2>

        <form action="" onSubmit={handleSubmit}>

            <label htmlFor="name-and-surname">Ime i prezime:</label><br/>
            <input type="text" defaultValue={certificateRequest.fullName}
                onChange={(e) => setCertificateRequest({...certificateRequest, fullName: e.target.value})}/><br/>

            <label htmlFor="dof">Datum rođenja:</label><br/>
            <input type="text" defaultValue={certificateRequest.dateOfBirth}
                onChange={(e) => setCertificateRequest({...certificateRequest, dateOfBirth: e.target.value})}/><br/>

            <label htmlFor="gender">Pol:</label><br/>
            <input type="text"
                onChange={(e) => setCertificateRequest({...certificateRequest, gender: e.target.value})}/><br/>

            <label htmlFor="jmbg">Jedinstveni matični broj gradjana:</label><br/>
            <input type="text" defaultValue={certificateRequest.jmbg}
                onChange={(e) => setCertificateRequest({...certificateRequest, jmbg: e.target.value})}/><br/>

            <label htmlFor="passport">Broj pasoša:</label><br/>
            <input type="text" defaultValue={certificateRequest.passportNum} 
                onChange={(e) => setCertificateRequest({...certificateRequest, passportNum: e.target.value})}/><br/>

            <label htmlFor="reason">Razlog za podnošenje zahteva:</label><br/>
            {/* <Editor 
                onEditorStateChange={handleEditorChange}/> */}
            <textarea name="reason" id="reason" cols="30" rows="10" 
                onChange={(e) => setCertificateRequest({...certificateRequest, reason: e.target.value})}></textarea><br/>

            <input className="button" type="submit" value="Pošalji" />

        </form>
        </div>
    </>
    );

}

export default CertificateRequestPageCitizen;