import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './pages/login/LoginPage';
import HomePageCitizen from './pages/citizen/HomePageCitizen';
import RegistrationPage from './pages/login/RegisterPage';
import VaccineCandidatePageCitizen from './pages/citizen/VaccineCandidatePageCitizen';
import CertificateRequestPageCitizen from './pages/citizen/CertificateRequestPageCitizen';
import AccordancePageCitizen from './pages/citizen/AccordancePageCitizen';
import ViewDocumentsCitizen from './pages/citizen/ViewDocumentsCitizen';
import Accordances from './pages/citizen/document-view/Accordances';
import Candidates from './pages/citizen/document-view/Candidates';
import Requests from './pages/citizen/document-view/Requests';
import Certificates from './pages/citizen/document-view/Certificates';

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
          <Route exact path="/accordance" element={<AccordancePageCitizen></AccordancePageCitizen>} />
          <Route exact path="/view-documents" element={<ViewDocumentsCitizen/>} />
          <Route exact path="/view-documents/accordances" element={<Accordances />} />
          <Route exact path="/view-documents/certificate-requests" element={<Requests />} />
          <Route exact path="/view-documents/certificate" element={<Certificates />} />
          <Route exact path="/view-documents/candidates" element={<Candidates />} />
        </Routes>
      </Router>
      
    </div>
  );
}

export default App;
