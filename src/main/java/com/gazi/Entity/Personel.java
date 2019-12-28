/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Entity;

/**
 *
 * @author fakdi
 */
public class Personel {

    private int id;
    private String personelName;
    private String password;

    public Personel(String personelName, String password) {
        this.personelName = personelName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonelName() {
        return personelName;
    }

    public void setPersonelName(String personelName) {
        this.personelName = personelName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
