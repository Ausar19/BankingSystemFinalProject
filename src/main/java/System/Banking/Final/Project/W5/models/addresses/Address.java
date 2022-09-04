package System.Banking.Final.Project.W5.models.addresses;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    @NotEmpty
    private String city;
    @NotEmpty
    private String country;
    @NotEmpty
    private String street;
    @NotEmpty
    private int postalCode;
    @NotEmpty
    private int apartmentNumber;


    //========================================CONSTRUCTOR========================================//


    public Address() {
    }

    public Address(String city, String country, int postalCode, int apartmentNumber, String street) {
        this.city = city;
        this.country = country;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
        this.street = street;

    }


    //========================================GETTERS AND SETTERS========================================//


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
}
