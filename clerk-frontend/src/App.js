import logo from "./logo.svg";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";
import { DigitalRequestsPage } from "./pages/DigitalRequestsPage";
import { ImmunizationReport } from "./pages/ImmunizationReport";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/" element={<DigitalRequestsPage />} />
          <Route
            exact
            path="/generate-report"
            element={<ImmunizationReport />}
          />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
