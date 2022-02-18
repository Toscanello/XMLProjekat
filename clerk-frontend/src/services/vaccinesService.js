import { getObjects, postObject, putObject } from "./axiosService";

const PATH = "vaccines";

export const getVaccines = (callback) => {
  return getObjects(`${PATH}/`, callback);
};

export const createVaccine = (vaccine, callback) => {
  const xmlData = `
  <vaccine xmlns="http://www.vakcinisoni.com">
    <manufacturer>${vaccine.manufacturer}</manufacturer>
    <name>${vaccine.name}</name>
    <quantity>${vaccine.quantity}</quantity>
  </vaccine>
  `;
  return postObject(`${PATH}/`, xmlData, callback);
};

export const updateVaccineQuantity = (vaccineId, quantity, callback) => {
  return putObject(
    `${PATH}/${vaccineId}/quantity?quantity=${quantity}`,
    callback
  );
};
