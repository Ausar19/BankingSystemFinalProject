package System.Banking.Final.Project.W5.dto;

import java.time.LocalDate;

public class AccountHolderDTO {

    private String username;
    private String password;
    private String name;
    private LocalDate birthDate;
    private String street;
    private Integer apartmentNumber;
    private Integer postalCode;
    private String city;
    private String country;
    private String mailingStreet;
    private Integer mailingApartmentNumber;
    private Integer mailingPostalCode;
    private String mailingCity;
    private String mailingCountry;


    //========================================CONSTRUCTOR========================================//


    public AccountHolderDTO(String username, String password, String name, LocalDate birthDate, String street, Integer apartmentNumber,
                            Integer postalCode, String city, String country, String mailingStreet, Integer mailingApartmentNumber, Integer mailingPostalCode,
                            String mailingCity, String mailingCountry) {

        this.username = username;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.mailingStreet = mailingStreet;
        this.mailingApartmentNumber = mailingApartmentNumber;
        this.mailingPostalCode = mailingPostalCode;
        this.mailingCity = mailingCity;
        this.mailingCountry = mailingCountry;
    }


    //========================================GETTERS AND SETTERS========================================//


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

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

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public Integer getMailingApartmentNumber() {
        return mailingApartmentNumber;
    }

    public void setMailingApartmentNumber(Integer mailingApartmentNumber) {
        this.mailingApartmentNumber = mailingApartmentNumber;
    }

    public Integer getMailingPostalCode() {
        return mailingPostalCode;
    }

    public void setMailingPostalCode(Integer mailingPostalCode) {
        this.mailingPostalCode = mailingPostalCode;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }
}
