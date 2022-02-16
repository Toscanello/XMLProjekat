package com.vakcinisoni.models;

import com.vakcinisoni.models.enums.Gender;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="citizen")
public class Citizen{

    private String name;

    private String surname;

    private Gender gender;

    private String dateOfBirth;

    private String jmbg; //id

    private String passportNum;

    private String email;

    private String password;

    public Citizen(){

    }

    public Citizen(String name, String surname, Gender gender, String dateOfBirth, String jmbg, String passportNum, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.jmbg = jmbg;
        this.passportNum = passportNum;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", passportNum='" + passportNum + '\'' +
                '}';
    }
}
