import { useState } from "react";
import { saveMemberToLocalStorage } from "../../utils/authorization";
import { postLoginObject } from "../../services/loginService";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { parseXmlToJs } from "../../services/parseService";

function LoginPage(){
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();

    function handleSubmit(e){
        e.preventDefault();
        var credentials = {username, password}

        postLoginObject(credentials, (response) => {
            if(response.status === 200){
                console.log(response.data.replaceAll('ns2:', ''));
                parseXmlToJs(response.data.replaceAll('ns2:', ''), (result) => {
                    console.log(result);
                    //setCertificates(result.certificates.certificate);
                    saveMemberToLocalStorage(result.citizen);
                });
                
                navigate('home');
            }
        });
    }

    return (
        <div className="for-container">
            <h1>Prijava</h1>
            <input type="text" placeholder="JMBG"
                onChange={(e) => setUsername(e.target.value)}/>
            <input type="password" placeholder="Lozinka" className=""
                onChange={(e) => setPassword(e.target.value)}/>
            <button className="button" onClick={handleSubmit}>Prijavi se</button>
            <Link to="/registration" className="">Registruj se</Link>
        </div>
    );
}

export default LoginPage;