package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="credentials")
public class Credentials {

    private String jmbg;
    private String password;

    public Credentials(){

    }
    public Credentials(String jmbg, String password) {
        this.jmbg = jmbg;
        this.password = password;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
