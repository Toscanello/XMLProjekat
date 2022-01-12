package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.examples.xquery.bookstore
     * 
     */
    public ObjectFactory() {
    }

    public DigitalCertificate createDigitalCertificate() { return new DigitalCertificate(); }

    public DigitalCertificateRequest createDigitalCertificateRequest() { return new DigitalCertificateRequest(); }

    public ImmunizationAccordance createImmunizationAccordance() { return new ImmunizationAccordance(); }

    public ImmunizationAccordance.VaccineEvidence createVaccineEvidence()
    { return new ImmunizationAccordance.VaccineEvidence(); }

    public ImmunizationAccordance.VaccineEvidence.Table createTable()
    { return new ImmunizationAccordance.VaccineEvidence.Table(); }

    public ImmunizationAccordance.VaccineEvidence.Table.Row createRow()
    { return new ImmunizationAccordance.VaccineEvidence.Table.Row(); }

    public ImmunizationAccordance.VaccineEvidence.DoctorInfo createDoctorInfo()
    { return new ImmunizationAccordance.VaccineEvidence.DoctorInfo(); }

    public ImmunizationReport createImmunizationReport() { return new ImmunizationReport(); }

    public ImmunizationReport.Manufacturers createManufacturers() { return new ImmunizationReport.Manufacturers(); }

    public ImmunizationReport.Manufacturers.Manufacturer createManufacturer()
    { return new ImmunizationReport.Manufacturers.Manufacturer(); }

    public VaccineCandidate createVaccineCandidate() { return new VaccineCandidate(); }

    public Options createOptions() { return new Options(); }

    public VaccinationReport createVaccinationReport() { return new VaccinationReport(); }

    public Doses createDoses() { return new Doses(); }

    public Dose createDose() { return new Dose(); }
}
