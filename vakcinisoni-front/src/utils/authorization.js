
export function saveMemberToLocalStorage(token){
    
    console.log(token);
    localStorage.setItem('dateOfBirth', token.dateOfBirth[0]);
    localStorage.setItem('email', token.email[0]);
    localStorage.setItem('jmbg', token.jmbg[0]);
    localStorage.setItem('name', token.name[0]);
    localStorage.setItem('passportNum', token.passportNum[0]);
    localStorage.setItem('surname', token.surname[0]);
    localStorage.setItem('token', token.token[0]);
}