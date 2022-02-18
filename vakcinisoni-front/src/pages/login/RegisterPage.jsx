import { useState } from "react";
import { postRegisterObject } from "../../services/loginService";
import { useNavigate } from "react-router-dom";
import { parseXmlToJs } from "../../services/parseService";
import { saveMemberToLocalStorage } from "../../utils/authorization";

function RegistrationPage(){
    const [citizen, setCitizen] = useState({
        name: "",
        surname: "",
        gender: "",
        dateOfBirth: "",
        jmbg: "",
        passportNum: "",
        email: "",
        password: "" // confirmPassword?
    });

    const navigate = useNavigate();

    function handleSubmit(e){
        e.preventDefault();
        postRegisterObject(citizen, (response) => {
            console.log(response.data);
            if(response.status === 200){
                parseXmlToJs(response.data.replaceAll('ns2:',''), (result) => {
                    console.log(result);
                    //setCertificates(result.certificates.certificate);
                    saveMemberToLocalStorage(result.citizen);
                });
                navigate('/home', {replace:true});
            }
        });
    }

    return (
        <div>
            <h1>Registracija</h1>
            <input type="text" placeholder="Ime" className=""
                onChange={(e) => setCitizen({...citizen, name: e.target.value})}/>
            
            <input type="text" placeholder="Prezime" className=""
                onChange={(e) => setCitizen({...citizen, surname: e.target.value})}/>

            <input type="text" placeholder="Pol" className=""
                onChange={(e) => setCitizen({...citizen, gender: e.target.value})}/>
                
            <input type="text" placeholder="Datum rodjenja" className=""
                onChange={(e) => setCitizen({...citizen, dateOfBirth: e.target.value})}/>

            <input type="text" placeholder="Jmbg" className=""
                onChange={(e) => setCitizen({...citizen, jmbg: e.target.value})}/>
                
            <input type="text" placeholder="Broj pasosa" className=""
                onChange={(e) => setCitizen({...citizen, passportNum: e.target.value})}/>

            <input type="text" placeholder="Email" className=""
                onChange={(e) => setCitizen({...citizen, email: e.target.value})}/>

            <input type="password" placeholder="Lozinka" className=""
                onChange={(e) => setCitizen({...citizen, password: e.target.value})}/>

            <button className="" onClick={handleSubmit}>Registruj se</button>
        </div>
    );
}
export default RegistrationPage;