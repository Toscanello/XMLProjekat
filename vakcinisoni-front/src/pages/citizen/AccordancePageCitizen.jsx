import { useState } from "react";
import { postAccordanceObject } from "../../services/accordanceService";
function AccordancePageCitizen(){

    const [accordance, setAccordance] = useState({
        jmbg: "", //or passportNum but still tag is jmbg
        surname: "",
        name: "",
        parentName: "",
        gender: 0,
        birthDate: "",
        birthPlace: "",
        address: "",
        post: "",
        city: "",
        homeNumber: "",
        phoneNum: "",
        email: "",
        workStatus: 0,
        employedAt: 0,
        socialSecurity: false,
        residenceName: "",
        isAccordant: false,
        medicineName: "",
    });

    function handleSubmit(e){
        e.preventDefault();
        // console.log(accordance);
        postAccordanceObject(accordance, (response) => {
            if(response.status === 200){
                console.log("redirect")
            }
        })
    }

    return(
        <div className="for-container">
        <h2 className="title">SAGLASNOST ZA SPROVODJENJE PREPORUCENE IMUNIZACIJE</h2>
        <p className="sub-title">(popunjava pacijent)</p>

        <form onSubmit={handleSubmit}>
            <label htmlFor="name-and-surname">Državljanstvo:</label><br/>
            <input type="radio" id="srbija" name="citizenship" value="0" defaultChecked />

            <label htmlFor="html">Republika Srbija</label>
            
            <input type="radio" id="ostalo" name="citizenship" value="1"/>
            <label htmlFor="html">Drugo</label>

            <br/><br/>
            <label htmlFor="jmbgOrPassport">JMBG/Broj pasosa</label>
            <input type="text"  
                onChange={(e) => setAccordance({...accordance, jmbg: e.target.value})}/><br/>

            <label htmlFor="surname">Prezime:</label><br/>
            <input type="text"
                onChange={(e) => setAccordance({...accordance, surname: e.target.value})}/><br/>

            <label htmlFor="name">Ime:</label><br/>
            <input type="text"
                onChange={(e) => setAccordance({...accordance, name: e.target.value})}/><br/>

            <label htmlFor="parent-name">Ime roditelja:</label><br/>
            <input type="text"
                onChange={(e) => setAccordance({...accordance, parentName: e.target.value})}/><br/>

            <label htmlFor="gender">Pol:</label><br/>
            <input type="radio" id="musko" name="gender" value="1"
                onChange={(e) => setAccordance({...accordance, gender: e.target.value})}/>
            <label htmlFor="male">Musko</label>
            <input type="radio" id="zensko" name="gender" value="0"
                onChange={(e) => setAccordance({...accordance, gender: e.target.value})}/>
            <label htmlFor="female">Zensko</label><br/>

            <label htmlFor="dob">Datum rodjenja:</label><br/>
            <input type="text"
                onChange={(e) => setAccordance({...accordance, birthDate: e.target.value})}/><br/>

            <label htmlFor="pob">Mesto rodjenja:</label><br/>
            <input type="text"
                onChange={(e) => setAccordance({...accordance, birthPlace: e.target.value})}/><br/>

            <label htmlFor="adress">Adresa (ulica i broj):</label><br />
            <input type="text" 
                onChange={(e) => setAccordance({...accordance, address: e.target.value})}/><br/>

            <label htmlFor="post">Mesto/Naselje:</label><br />
            <input type="text" 
                onChange={(e) => setAccordance({...accordance, post: e.target.value})}/><br/>

            <label htmlFor="city">Opština/Grad</label><br />
            <input type="text" 
                onChange={(e) => setAccordance({...accordance, city: e.target.value})}/><br/>

            <label htmlFor="phone">Tel. fiksni</label><br/>
            <input type="text" 
                onChange={(e) => setAccordance({...accordance, homeNumber: e.target.value})}/><br/>

            <label htmlFor="mobile-phone">Tel. mobilni:</label><br/>
            <input type="text" 
                onChange={(e) => setAccordance({...accordance, phoneNum: e.target.value})}/><br/>

            <label htmlFor="email">Email</label><br/>
            <input type="text" 
                onChange={(e) => setAccordance({...accordance, email: e.target.value})}/><br/>

            <label htmlFor="work">Radni status:</label><br/>
            <input type="radio" id="zaposlen" name="work" value="0" 
                onChange={(e) => setAccordance({...accordance, workStatus: e.target.value})}/>
            <label htmlFor="zaposlen">Zaposlen</label>
            <input type="radio" id="nezaposlen" name="work" value="1" 
                onChange={(e) => setAccordance({...accordance, workStatus: e.target.value})}/>
            <label htmlFor="nezaposlen">Nezaposlen</label>
            <input type="radio" id="penzioner" name="work" value="2" 
                onChange={(e) => setAccordance({...accordance, workStatus: e.target.value})}/>
            <label htmlFor="penzioner">Penzioner</label>
            <input type="radio" id="ucenik" name="work" value="3" 
                onChange={(e) => setAccordance({...accordance, workStatus: e.target.value})}/>
            <label htmlFor="ucenik">Ucenik</label>
            <input type="radio" id="student" name="work" value="4" 
                onChange={(e) => setAccordance({...accordance, workStatus: e.target.value})}/>
            <label htmlFor="student">Student</label>
            <input type="radio" id="dete" name="work" value="5" 
                onChange={(e) => setAccordance({...accordance, workStatus: e.target.value})}/>
            <label htmlFor="dete">Dete</label><br/>

            <label htmlFor="work-place">Zanimanje zaposlenog:</label><br/>
            <input type="radio" id="zd-zastita" name="work-place" value="0" 
                onChange={(e) => setAccordance({...accordance, employedAt: e.target.value})}/>
            <label htmlFor="zd-zastita">Zdravstvena zaštita</label>
            <input type="radio" id="soc-zastita" name="work-place" value="1" 
                onChange={(e) => setAccordance({...accordance, employedAt: e.target.value})}/>
            <label htmlFor="soc-zastita">Socijalna zaštita</label>
            <input type="radio" id="prosveta" name="work-place" value="2" 
                onChange={(e) => setAccordance({...accordance, employedAt: e.target.value})}/>
            <label htmlFor="prosveta">Prosveta</label>
            <input type="radio" id="mup" name="work-place" value="3" 
                onChange={(e) => setAccordance({...accordance, employedAt: e.target.value})}/>
            <label htmlFor="mup">MUP</label>
            <input type="radio" id="vojska" name="work-place" value="4" 
                onChange={(e) => setAccordance({...accordance, employedAt: e.target.value})}/>
            <label htmlFor="vojska">Vojska RS</label>
            <input type="radio" id="drugo" name="work-place" value="5" 
                onChange={(e) => setAccordance({...accordance, employedAt: e.target.value})}/>
            <label htmlFor="drugo">Drugo</label><br/>

            <label htmlFor="soc-zast">Korisnik ustanove soc. zašt.:</label><br/>
            <input type="radio" id="soc-zast-da" name="soc-zast" value="Da" 
                onChange={() => setAccordance({...accordance, socialSecurity: true})}/>
            <label htmlFor="soc-zast-da">Da</label>
            <input type="radio" id="soc-zast-ne" name="soc-zast" value="Ne" 
                onChange={() => setAccordance({...accordance, socialSecurity: false})}/>
            <label htmlFor="soc-zast-ne">Ne</label><br/>

            <label htmlFor="municipality">Naziv i opština sedišta:</label><br/>
            <input type="text" 
                onChange={(e) => setAccordance({...accordance, residenceName: e.target.value})}/><br/>

            <label htmlFor="statement">Izjavljujem da</label><br/>
            <input type="radio" id="accept" name="statement" value="Saglasan" 
                onChange={() => setAccordance({...accordance, isAccordant: true})}/>
            <label htmlFor="accept">SAM SAGLASAN</label>
            <input type="radio" id="decline" name="statement" value="Nisam saglasan" 
                onChange={() => setAccordance({...accordance, isAccordant: false})}/>
            <label htmlFor="decline">NISAM SAGLASAN</label><br/>
            <label htmlFor="statement-medicine">sa sprovodjenjem aktivne/pasivne imunizacije (naziv imunološkog leka)</label><br/>
            <input type="text" 
                onChange={(e) => setAccordance({...accordance, medicineName: e.target.value})}/><br/>

            <p>Lekar mi je objasnio prednosti i razlike od sprovodjenja aktive/pasivne imunizacije navecenim imunološkim lekom.</p>

            <input className="button" type="submit" value="Pošalji" />

        </form>
    </div>
    );

}

export default AccordancePageCitizen;