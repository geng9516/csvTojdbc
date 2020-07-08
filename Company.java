/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.jp.tihtih.homework;

/**
 *
 * @author user
 */
public class Company {
    private String ID;
    private String katagaki;
    private String name;
    private String Email;

    public Company() {
    }

    public Company(String ID, String katagaki, String name, String Email) {
        this.ID = ID;
        this.katagaki = katagaki;
        this.name = name;
        this.Email = Email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String companyName) {
        this.ID = companyName;
    }

    public String getKatagaki() {
        return katagaki;
    }

    public void setKatagaki(String katagaki) {
        this.katagaki = katagaki;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Company{" + "companyName=" + ID + ", katagaki=" + katagaki + ", name=" + name + ", Email=" + Email + '}';
    }
    
}
