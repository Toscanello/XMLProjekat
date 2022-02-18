import { useState, useEffect } from "react";
import { postCandidateObject } from "../../services/candidateService";
import NavigationHeader from "../../components/header/NavigationHeader";
import { parseXmlToJs } from "../../services/parseService";

function VaccineCandidatePageCitizen(){

    const[candidate, setCandidate] = useState({
        residence: 0,
        jmbg: localStorage.getItem('jmbg'),
        name: localStorage.getItem('name'),
        surname: localStorage.getItem('surname'),
        email: localStorage.getItem('email'), //AUTOCOMPLETE
        phoneNum: "",
        homeNum: "",
        location: "",
        options: [],
        bloodDonor: false
    });

    function handleChangeOfVaccine(e){
        if(e.target.checked){
            candidate.options.push(e.target.value);
        }
        else{
            let index = candidate.options.indexOf(e.target.value);
            candidate.options.splice(index, 1);
        }
    }

    function handleSubmit(e){
        console.log(localStorage.getItem('jmbg'));
        e.preventDefault();
        if(candidate.options.includes("any")){
            candidate.options = ["Pfizer-BioNTech", "Sputnik V", "AstraZeneca", "Moderna"];
        }
        postCandidateObject(candidate, (response) => {
            console.log(response.data);
            parseXmlToJs(response.data.replaceAll('ns2:', ''), (result) => {
                alert("PROVERITE EMAIL.");
            });
        });
    }

    return(
        <>
            <NavigationHeader />
            <div className="for-container">
                <h2>Interesovanje</h2>
                <div>
                    <input type="radio" id="rs" name="citizen" value="0" defaultChecked 
                        onChange={(e) => setCandidate({...candidate, residence: e.target.value})}/>
                    <label htmlFor="0">Drzavljanin Republike Srbije</label>
                </div>
                <div>
                    <input type="radio" id="rsN" name="citizen" value="1"
                        onChange={(e) => setCandidate({...candidate, residence: e.target.value})}/>
                    <label htmlFor="1">Strani drzavljanin sa boravkom u RS</label>
                </div>   
                <div>
                    <input type="radio" id="rsY" name="citizen" value="2"
                        onChange={(e) => setCandidate({...candidate, residence: e.target.value})}/>
                    <label htmlFor="2">Strani drzavljanin bez boravka u RS</label>
                </div>

                <input type="text" placeholder="Jmbg" className="" defaultValue={candidate.jmbg}
                    onChange={(e) => setCandidate({...candidate, jmbg: e.target.value})}/>

                <input type="text" placeholder="Ime" className="" defaultValue={candidate.name}
                    onChange={(e) => setCandidate({...candidate, name: e.target.value})}/>
                
                <input type="text" placeholder="Prezime" className="" defaultValue={candidate.surname}
                    onChange={(e) => setCandidate({...candidate, surname: e.target.value})}/>
                
                <input type="text" placeholder="Email" className="" defaultValue={candidate.email}
                    onChange={(e) => setCandidate({...candidate, email: e.target.value})}/>
                    
                <input type="text" placeholder="Broj mobilnog" className=""
                    onChange={(e) => setCandidate({...candidate, phoneNum: e.target.value})}/>
                
                <input type="text" placeholder="Broj fiksnog" className=""
                    onChange={(e) => setCandidate({...candidate, homeNum: e.target.value})}/>
                
                <input type="text" placeholder="Lokacija" className=""
                    onChange={(e) => setCandidate({...candidate, location: e.target.value})}/>
                
                <input type="checkbox" id="pfizer" name="pfizer" value="Pfizer-BioNTech"
                    onChange={handleChangeOfVaccine}/>
                <label htmlFor="pfizer">Pfizer-BioNTech</label><br/>

                <input type="checkbox" id="SputnikV" name="SputnikV" value="Sputnik V"
                    onChange={handleChangeOfVaccine}/>
                <label htmlFor="Sputnik V">Sputnik V (Gamaleya istrazivacki centar)</label><br/>

                <input type="checkbox" id="AstraZeneca" name="AstraZeneca" value="AstraZeneca"
                    onChange={handleChangeOfVaccine}/>
                <label htmlFor="AstraZeneca">AstraZeneca</label><br/>

                <input type="checkbox" id="Moderna" name="Moderna" value="Moderna"
                    onChange={handleChangeOfVaccine}/>
                <label htmlFor="Moderna">Moderna</label><br/>

                <input type="checkbox" id="any" name="any" value="any"
                    onChange={handleChangeOfVaccine}/>
                <label htmlFor="any">Bilo koja</label><br/>

                <label>Da li ste dobrovoljni davalac krvi?</label>
                <div>
                    <input type="radio" id="donorY" name="donor" value="1" 
                        onChange={(e) => setCandidate({...candidate, bloodDonor: true})}/>
                    <label htmlFor="1">Da</label>
                </div>
                <div>
                    <input type="radio" id="donorN" name="donor" value="0" defaultChecked
                        onChange={(e) => setCandidate({...candidate, bloodDonor: false})}/>
                    <label htmlFor="1">Ne</label>
                </div>
                <br/>
                <button className="button"  onClick={handleSubmit}>Podnesi interesovanje</button>
            </div>
            
        </>
    );
}

export default VaccineCandidatePageCitizen;