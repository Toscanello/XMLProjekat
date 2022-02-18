import { Link } from 'react-router-dom';

function NavigationHeader(){

    return(
        <nav>
            <ul className="nav" id="navbar">
                <li>
                    <Link to={`/candidate`}>Interesovanje</Link>
                </li>
                <li>
                    <Link to={`/accordance`}>Saglasnost</Link>
                </li>
                <li>
                    <Link to={`/certificate-request`}>Zahtev za sertifikat</Link>
                </li>
                <li>
                    <Link to={`/view-documents`}>Pregledaj dokumente</Link>
                </li>
                <li className="right">
                    <Link to={`/`} onClick={() => localStorage.clear()}>Izloguj se</Link>
                </li>
            </ul>
        </nav>                 
    );
}

export default NavigationHeader;