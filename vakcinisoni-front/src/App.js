import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './pages/login/LoginPage';
import HomePageCitizen from './pages/citizen/HomePageCitizen';
import RegistrationPage from './pages/login/RegisterPage';
import VaccineCandidatePageCitizen from './pages/citizen/VaccineCandidatePageCitizen';
import CertificateRequestPageCitizen from './pages/citizen/CertificateRequestPageCitizen';

import './assets/style.css';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/" element={<LoginPage />} />
          <Route exact path="/home" element={<HomePageCitizen />}/>
          <Route exact path="/registration" element={<RegistrationPage />}/>
          <Route exact path="/candidate" element={<VaccineCandidatePageCitizen />}/>
          <Route exact path="/certificate-request" element={<CertificateRequestPageCitizen />} />
        </Routes>
      </Router>
      
    </div>
  );
}

export default App;
