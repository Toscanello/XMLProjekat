import axios from "axios";
import { useState } from "react";
import { getAllDocumentsForPhrase } from "../services/citizenDocumentsService";
import { parseXmlToJs } from "../services/parseService";

function SearchPage() {
  const [searchField, setSearchField] = useState("");

  const [accordances, setAccordances] = useState([]);
  const [certificates, setCertificates] = useState([]);
  const [reports, setReports] = useState([]);

  var count = 1;

  function handleClick(e) {
    e.preventDefault();
    getAllDocumentsForPhrase(searchField, (response) => {
      parseXmlToJs(
        response.data.replaceAll("ns2:", "").replaceAll("ns3:", ""),
        (result) => {
          console.log(result.allDocuments);
          if (result.allDocuments.accordances[0]) {
            setAccordances(result.allDocuments.accordances[0].accordance);
          }
          if (result.allDocuments.digitalCertificates[0]) {
            setCertificates(
              result.allDocuments.digitalCertificates[0].certificate
            );
          }
          if (result.allDocuments.vaccinationReports[0]) {
            setReports(
              result.allDocuments.vaccinationReports[0].vaccinationReport
            );
          }
        }
      );
    });
  }
  function displayFile(e) {
    e.preventDefault();
    console.log(e.target.id);
    const path = `http://localhost:3000/`;
    axios.get(`${path}${e.target.id}`).then((response) => {
      window.open(`http://172.22.240.1:8081/${response.data}`);
    });
  }
  return (
    <div className="for-container">
      <input type="text" onChange={(e) => setSearchField(e.target.value)} />
      <button onClick={handleClick}>Pretrazi</button>
      <h2>Saglasnosti</h2>
      {accordances.map((accordance) => {
        return (
          <div>
            <h4>{accordance.jmbg}</h4>
            <button
              id={
                "accordances/downloadhtml/" +
                accordance.jmbg +
                "_" +
                accordance.date
              }
              onClick={displayFile}
            >
              Prikazi saglasnost
            </button>
          </div>
        );
      })}
      <h2>Sertifikati</h2>
      {certificates.map((cert) => {
        return (
          <div>
            <h4>{cert.id}</h4>
            <button
              id={"certificates/downloadhtml/" + cert.id}
              onClick={displayFile}
            >
              Prikazi sertifikat
            </button>
          </div>
        );
      })}
      <h2>Izvestaji o vakcinaciji</h2>
      {reports.map((report) => {
        return (
          <div>
            <h4>{count++}</h4>
            <button
              id={"vaccine-reports/downloadhtml/" + count}
              onClick={displayFile}
            >
              Prikazi izvestaj
            </button>
          </div>
        );
      })}
    </div>
  );
}

export default SearchPage;
