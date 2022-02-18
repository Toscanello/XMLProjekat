import { getObjects } from "./axiosService";

const PATH = "immunization-reports";

export const generateImmunizationReport = (dateFrom, dateUntil, callback) => {
  return getObjects(
    `${PATH}/generate?dateFrom=${dateFrom}&dateUntil=${dateUntil}`,
    callback
  );
};

export const getImmunizationReports = (callback) => {
  return getObjects(`${PATH}/`, callback);
};
