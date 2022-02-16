import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './pages/login/LoginPage';
import HomePageCitizen from './pages/citizen/HomePageCitizen';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/" element={<LoginPage />} />
          <Route exact path="/home" element={<HomePageCitizen />}/>
        </Routes>
      </Router>
      
    </div>
  );
}

export default App;
