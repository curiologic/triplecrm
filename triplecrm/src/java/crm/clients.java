/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author xulix
 */
public class clients implements Serializable {
 private int idclient;
 private int phoneNumber;
 private String Name;
 private String Address;
 private String City;
 private String State;
 private String Country;
 private String postalCode;
 private String Prospect;
 private String Email;
 private Boolean formerClient;
 private Boolean Active;
 private String Comments;

 
 private Map<String, String> states;
    public Map<String, String> getStates() {
        states = new LinkedHashMap<>();
        states.put("Alabama", "Alabama");
        states.put("Alaska", "Alaska");
        states.put("Arizona", "Arizona");
        states.put("Arkansas", "Arkansas");
        states.put("California", "California");
        states.put("Colorado", "Colorado");
        states.put("Connecticut", "Connecticut");
        states.put("Delaware", "Delaware");
        states.put("Florida", "Florida");
        states.put("Georgia", "Georgia");
        states.put("Hawaii", "Hawii");
        states.put("Idaho", "Idaho");
        states.put("Illinois", "Illinois");
        states.put("Indiana", "Indiana");
        states.put("Iowa", "Iowa");
        states.put("Kansas", "Kansas");
        states.put("Kentucky", "Kentucky");
        states.put("Louisiana", "Louisiana");
        states.put("Maine", "Maine");
        states.put("Maryland", "Maryland");
        states.put("Massachusetts", "Massachusetts");
        states.put("Michigan", "Michigan");
        states.put("Minnesota", "Minnesota");
        states.put("Mississippi", "Mississippi");
        states.put("Missouri", "Missouri");
        states.put("Montana", "Montana");
        states.put("Nebraska", "Nebraska");
        states.put("Nevada", "Nevada");
        states.put("New Hampshire", "New Hampshire");
        states.put("New Jersey", "New Jersey");
        states.put("New Mexico", "New Mexico");
        states.put("New York", "New York");
        states.put("North Carolina", "North Carolina");
        states.put("North Dakota", "North Dakota");
        states.put("Ohio", "Ohio");
        states.put("Oklahoma", "Oklahoma");
        states.put("Oregon", "Oregon");
        states.put("Pennsylvania", "Pensylvania");
        states.put("Rhode Island", "Rhode Island");
        states.put("South Carolina", "South Carolina");
        states.put("South Dakota", "South Dakota");
        states.put("Tennessee", "Tennessee");
        states.put("Texas", "Texas");
        states.put("Utah", "Utah");
        states.put("Vermont", "Vermont");
        states.put("Virginia", "Virginia");
        states.put("Washington", "Washington");
        states.put("Washington DC", "Washington DC");
        states.put("West Virginia", "West Virginia");
        states.put("Wisconson", "Wisconson");
        states.put("Wyoming", "Wyoming");
        
        return states;
    }
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

    public int getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(int PhoneNumber) {
        this.phoneNumber = PhoneNumber;
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

    public String getpostalCode() {
        return postalCode;
    }

    public void setpostalCode(String PostalCode) {
        this.postalCode = PostalCode;
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

    public Boolean getformerClient() {
        return formerClient;
    }

    public void setformerClient(Boolean FormerClient) {
        this.formerClient = FormerClient;
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
