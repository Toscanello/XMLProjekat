import { useState } from "react";
import { postCertificateRequestObject } from "../../services/certificateRequestService";
import { parseXmlToJs } from "../../services/parseService";
import NavigationHeader from "../../components/header/NavigationHeader";
import { Editor } from "react-draft-wysiwyg";
import "react-draft-wysiwyg/dist/react-draft-wysiwyg.css";
import { convertToHTML } from "draft-convert";

function CertificateRequestPageCitizen(){

    const [richReason, setRichReason] = useState("");

    const[certificateRequest, setCertificateRequest] = useState({
        fullName: "",
        dateOfBirth: "",
        gender: 0,
        jmbg: "",
        passportNum: "", // AUTOCOMPLETE?
        reason: "" //RICH EDIT?
    });
    
    function handleSubmit(e){
        alert(richReason);
        e.preventDefault();
        console.log(certificateRequest);
        postCertificateRequestObject(certificateRequest, richReason, (response) => {
            console.log(response.data);
            if(response.status === 200){
                alert("Uspesno podnet zahtev!");
            }
            // parseXmlToJs(response.data, (result) => {
            //     alert(result.certificateRequest.fullName);
            // })
        })
    }

    function handleEditorChange(e){
        //console.log(e.getCurrentContent());
        const html = convertToHTML(e.getCurrentContent())
        setRichReason(html);
    }
    return(
    <>
        <NavigationHeader />
        <div className="for-container">
        
        <h2>Zahtev za Sertifikat</h2>

        <form action="" onSubmit={handleSubmit}>

            <label htmlFor="name-and-surname">Ime i prezime:</label><br/>
            <input type="text" 
                onChange={(e) => setCertificateRequest({...certificateRequest, fullName: e.target.value})}/><br/>

            <label htmlFor="dof">Datum rođenja:</label><br/>
            <input type="text" 
                onChange={(e) => setCertificateRequest({...certificateRequest, dateOfBirth: e.target.value})}/><br/>

            <label htmlFor="gender">Pol:</label><br/>
            <input type="text"
                onChange={(e) => setCertificateRequest({...certificateRequest, gender: e.target.value})}/><br/>

            <label htmlFor="jmbg">Jedinstveni matični broj gradjana:</label><br/>
            <input type="text" 
                onChange={(e) => setCertificateRequest({...certificateRequest, jmbg: e.target.value})}/><br/>

            <label htmlFor="passport">Broj pasoša:</label><br/>
            <input type="text" 
                onChange={(e) => setCertificateRequest({...certificateRequest, passportNum: e.target.value})}/><br/>

            <label htmlFor="reason">Razlog za podnošenje zahteva:</label><br/>
            <Editor 
                onEditorStateChange={handleEditorChange}/>
            {/* <textarea name="reason" id="reason" cols="30" rows="10" 
                onChange={(e) => setCertificateRequest({...certificateRequest, reason: e.target.value})}></textarea><br/> */}

            <input className="button" type="submit" value="Pošalji" />

        </form>
        </div>
    </>
    );

}

export default CertificateRequestPageCitizen;