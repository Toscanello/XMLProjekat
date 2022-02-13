package vakcinisoniclerk.models;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vaccine")
public class Vaccine {

    private long id;
    private String manufacturer;
    private String name;
    private int quantity;

    public Vaccine() {};

    public Vaccine(long id, String manufacturer, String vaccineName, int quantity) {
        this.manufacturer = manufacturer;
        this.name = vaccineName;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
