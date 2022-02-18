import { useState } from "react";
import { generateImmunizationReport } from "../services/immunizationReportService";

export const ImmunizationReport = () => {
  const [dateFrom, setDateFrom] = useState("");
  const [dateUntil, setDateUntil] = useState("");

  const generateReport = () => {
    generateImmunizationReport(dateFrom, dateUntil, window.location.reload());
  };

  return (
    <>
      <input
        type="text"
        value={dateFrom}
        onChange={(e) => setDateFrom(e.target.value)}
        placeholder="Date from"
      />

      <input
        type="text"
        value={dateUntil}
        onChange={(e) => setDateUntil(e.target.value)}
        placeholder="Date until"
      />

      <button onClick={() => generateReport()}>Generisi izvestaj</button>
    </>
  );
};
