import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { ImmunizationReport } from "./pages/ImmunizationReport";
import { DigitalRequestsPage } from "./pages/DigitalRequestsPage";
import SearchPage from "./pages/SearchPage";
import { VaccinesPage } from "./pages/VaccinesPage";
import { WelcomePage } from "./pages/WelcomePage";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/" element={<WelcomePage />} />
          <Route exact path="/certificates" element={<DigitalRequestsPage />} />
          <Route
            exact
            path="/generate-report"
            element={<ImmunizationReport />}
          />
          <Route exact path="/search" element={<SearchPage />}/>
          <Route exact path="/vaccines" element={<VaccinesPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
