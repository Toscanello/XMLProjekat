package vakcinisoniclerk.models;


import vakcinisoniclerk.models.ImmunizationReport.Manufacturers.Manufacturer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vaccine")
public class Vaccine {

    private long id;
    private Manufacturer manufacturer;
    private int quantity;

    public Vaccine() {};

    public Vaccine(Manufacturer manufacturer, int quantity) {
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    public Vaccine(long id, Manufacturer manufacturer, int quantity) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
