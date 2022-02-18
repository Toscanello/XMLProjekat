import { useEffect, useState } from "react";
import { parseXmlToJs } from "../services/parseService";
import {
  getVaccines,
  updateVaccineQuantity,
} from "../services/vaccinesService";

export const VaccinesPage = () => {
  const [vaccines, setVaccines] = useState([]);
  const [vaccineId, setVaccineId] = useState("");
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
    updateVaccineQuantity(vaccineId, quantity, window.location.reload());
  };

  return (
    <>
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
                    <button onClick={() => setVaccineId(vaccine.id)}>
                      Izmeni kolicinu
                    </button>
                  </td>
                  {vaccineId && vaccine.id === vaccineId && (
                    <>
                      <td>
                        <input
                          type="number"
                          value={quantity}
                          min="0"
                          onChange={(e) => setQuantity(e.target.value)}
                        />
                      </td>
                      <td>
                        <button onClick={() => handleUpdateVaccineQuantity()}>
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
    </>
  );
};
