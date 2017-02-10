/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.io.Serializable;

/**
 *
 * @author xulix
 */
public class clients implements Serializable {
 private int idclient;
 private int PhoneNumber;
 private String Name;
 private String Address;
 private String City;
 private String State;
 private String Country;
 private String PostalCode;
 private String Prospect;
 private String Email;
 private Boolean FormerClient;
 private Boolean Active;
 private String Comments;

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    
    
    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public String getProspect() {
        return Prospect;
    }

    public void setProspect(String Prospect) {
        this.Prospect = Prospect;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Boolean getFormerClient() {
        return FormerClient;
    }

    public void setFormerClient(Boolean FormerClient) {
        this.FormerClient = FormerClient;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean Active) {
        this.Active = Active;
    }
 
 public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.idclient + ";");
        buffer.append("Name: " + Name);
        return buffer.toString();
    }
}
