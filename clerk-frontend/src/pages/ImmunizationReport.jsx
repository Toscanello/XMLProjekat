import { useEffect, useState } from "react";
import {
  downloadHtml,
  downloadHtml3001,
  downloadPdf3001,
} from "../services/axiosService";
import {
  generateImmunizationReport,
  getImmunizationReports,
} from "../services/immunizationReportService";
import { parseXmlToJs } from "../services/parseService";
import { SERVER_URL } from "../utils/constants";

export const ImmunizationReport = () => {
  const [dateFrom, setDateFrom] = useState("");
  const [dateUntil, setDateUntil] = useState("");

  const [reports, setReports] = useState([]);

  useEffect(() => {
    getImmunizationReports((response) => {
      parseXmlToJs(response.data, (result) => {
        const request = result["reports"].report;
        setReports(request);
      });
    });
  }, []);

  const generateReport = () => {
    generateImmunizationReport(dateFrom, dateUntil, window.location.reload());
  };

  const fetchImmunizationReport = (e) => {
    downloadHtml3001("immunization-reports", e.target.id, (response) => {
      if (response.status === 200) {
        window.open(`${SERVER_URL}/${response.data}`);
      }
    });
    downloadPdf3001("immunization-reports", e.target.id, (response) => {
      if (response.status === 200) {
        window.open(`${SERVER_URL}/${response.data}`);
      }
    });
  };

  return (
    <div className="for-container">
      <h1>Izvestaji o imunizaciji</h1>
      <input
        type="text"
        value={dateFrom}
        onChange={(e) => setDateFrom(e.target.value)}
        placeholder="Pocetni datum"
      />

      <input
        type="text"
        value={dateUntil}
        onChange={(e) => setDateUntil(e.target.value)}
        placeholder="Krajnji datum"
      />

      <button className="button" onClick={() => generateReport()}>
        Generisi izvestaj
      </button>
      <br />
      {reports.map((report, i) => {
        return (
          <>
            <br />
            <div>
              {report.startDate} - {report.finishDate} .
              <button
                id={i + 1}
                className="button"
                onClick={(e) => fetchImmunizationReport(e)}
              >
                Pregledaj i sacuvaj
              </button>
            </div>
            <br />
          </>
        );
      })}
    </div>
  );
};
