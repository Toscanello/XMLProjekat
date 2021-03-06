import { useEffect, useState } from "react";
import { parseXmlToJs } from "../services/parseService";
import {
  createVaccine,
  deleteVaccine,
  getVaccines,
  updateVaccineQuantity,
} from "../services/vaccinesService";

export const VaccinesPage = () => {
  const [vaccines, setVaccines] = useState([]);
  const [vaccineId, setVaccineId] = useState("");
  const [newQuantity, setNewQuantity] = useState(0);

  const [formVisible, setFormVisible] = useState(false);
  const [manufacturer, setManufacturer] = useState("");
  const [name, setName] = useState("");
  const [quantity, setQuantity] = useState(0);

  useEffect(() => {
    getVaccines((response) => {
      parseXmlToJs(response.data, (result) => {
        const request = result["vaccines"].vaccine;
        setVaccines(request);
      });
    });
  }, []);

  const handleUpdateVaccineQuantity = () => {
    updateVaccineQuantity(vaccineId, newQuantity, window.location.reload());
  };

  const handleCreateVaccine = () => {
    createVaccine({ manufacturer, name, quantity }, window.location.reload());
    setFormVisible(false);
  };

  const handleDeleteVaccine = (vaccineToDeleteId) => {
    deleteVaccine(vaccineToDeleteId, window.location.reload());
  };

  return (
    <div className="for-container">
      <h1>Vakcine</h1>
      <table>
        <thead>
          <tr>
            <td>Proizvodjac</td>
            <td>Naziv</td>
            <td>Kolicina</td>
          </tr>
        </thead>
        <tbody>
          {vaccines &&
            vaccines.map((vaccine, i) => {
              return (
                <tr key={i}>
                  <td>{vaccine.manufacturer}</td>
                  <td>{vaccine.name}</td>
                  <td>{vaccine.quantity}</td>
                  <td>
                    <button
                      className="button"
                      onClick={() => setVaccineId(vaccine.id)}
                    >
                      Izmeni kolicinu
                    </button>
                  </td>
                  {vaccineId && vaccine.id === vaccineId && (
                    <>
                      <td>
                        <input
                          type="number"
                          value={newQuantity}
                          min="0"
                          onChange={(e) => setNewQuantity(e.target.value)}
                        />
                      </td>
                      <td>
                        <button
                          className="button"
                          onClick={() => handleUpdateVaccineQuantity()}
                        >
                          Sacuvaj
                        </button>
                      </td>
                    </>
                  )}
                </tr>
              );
            })}
        </tbody>
      </table>
      <button className="button" onClick={() => setFormVisible(true)}>
        Kreiraj novu vakcinu
      </button>
      <br />
      <br />
      {formVisible && (
        <form>
          Proizvodjac:
          <br />
          <input
            type="text"
            value={manufacturer}
            onChange={(e) => setManufacturer(e.target.value)}
          />
          <br />
          Naziv:
          <br />
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <br />
          Kolicina:
          <br />
          <input
            type="text"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
          />
          <br />
          <br />
          <button className="button" onClick={() => handleCreateVaccine()}>
            Kreiraj
          </button>
        </form>
      )}
    </div>
  );
};
