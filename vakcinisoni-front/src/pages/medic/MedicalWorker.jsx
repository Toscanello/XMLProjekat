import { useState } from "react";
import { postVaccineEvidenceInAccordance } from "../../services/medicService";
import { parseXmlToJs } from "../../services/parseService";

function MedicalWorker(){

    const [vaccineEvidence, setVaccineEvidence] = useState({
        jmbg: "",
        institution: "",
        vaccinationNum: 0,
        fullName: "",
        fax: "",
        phoneNum: "",
        vaccineName: "",
        dateIssued: "",
        issueMethod: 0,
        bodyPart: 0,
        batch: 0,
        manufacturer: "",
        reaction: ""
    });

    function handleSubmit(e){
        e.preventDefault();
        console.log(vaccineEvidence);

        postVaccineEvidenceInAccordance(vaccineEvidence, (response) => {
            parseXmlToJs(response.data.replaceAll('ns3:', ''), (result) => {
                if(result){
                    alert("USPESNO");
                }
                else{
                    alert("NEUSPESNO");
                }
            })
            
        })
    }

    return(
        <>
            <div className="for-container">
                <h2 class="title">EVIDENCIJA O VAKCINACIJI PROTIV COVID-19</h2>
                <p class="sub-title">(popunjava zdravstveni radnik)</p>

                <form onSubmit={handleSubmit}>

                    <label htmlFor="patient">JMBG Pacijenta:</label><br/>
                    <input type="text" 
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, jmbg: e.target.value})}/><br/>

                    <label htmlFor="institution">Zdravstvena ustanova:</label><br/>
                    <input type="text" 
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, institution: e.target.value})}/><br/>

                    <label htmlFor="vaccinationNum">Vakcinacijski punkt:</label><br/>
                    <input type="text" 
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, vaccinationNum: e.target.value})}/><br/>

                    <p>Informacije o doktoru</p>

                    <label htmlFor="doctorName">Ime i prezime lekara:</label><br/>
                    <input type="text" 
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, fullName: e.target.value})}/><br/>

                    <label htmlFor="doctorFax">Faksimil lekara:</label><br/>
                    <input type="text"
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, fax: e.target.value})}/><br/>

                    <label htmlFor="doctorMobile">Br. telefona lekara:</label><br/>
                    <input type="text"
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, phoneNum: e.target.value})}/><br/>

                    <p>Informacije i vakcini</p>

                    <label htmlFor="vaccineName">Naziv vakcine:</label><br/>
                    <input type="text" 
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, vaccineName: e.target.value})}/><br/>

                    <label htmlFor="dateIssued">Datum davanja vakcine:</label><br/>
                    <input type="text" 
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, dateIssued: e.target.value})}/><br/>

                    <label htmlFor="issueMethod">Način davanja vakcine:</label><br/>
                    <input type="text" 
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, issueMethod: e.target.value})}/><br/>

                    <label htmlFor="bodyPart">Ekstremitet:</label><br/>
                    <input type="radio" id="dr" name="bodyPart" value="dr"
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, bodyPart: e.target.value})}/>
                    <label htmlFor="dr">1) DR</label>
                    <input type="radio" id="lr" name="bodyPart" value="lr"
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, bodyPart: e.target.value})}/>
                    <label htmlFor="lr">2) LR</label><br/>

                    <label htmlFor="batch">Serija vakcine (lot):</label><br/>
                    <input type="text"
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, batch: e.target.value})}/><br/>

                    <label htmlFor="manufacturer">Proizvodjač:</label><br/>
                    <input type="text" 
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, manufacturer: e.target.value})}/><br/>

                    <label htmlFor="reaction">Neželjena reakcija:</label><br/>
                    <input type="text"
                        onChange={(e) => setVaccineEvidence({...vaccineEvidence, reaction: e.target.value})}/><br/>

                    <input className="button" type="submit" value="Pošalji"/>
                </form>
            </div>
        </>
    );
}

export default MedicalWorker;