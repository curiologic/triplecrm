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
public class interactions implements Serializable  {
    private int idinteractions;
    private boolean Phone;
    private boolean InPerson;
    private boolean Email;
    private boolean ConferenceCall;
    private int TimeOfContact;
    private int idclient;
    private clients client;
  
    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }
   
    
    
    private Map<Integer, String> clients;

    public clients getClient() {
        return client;
    }

    public void setClient(clients client) {
        this.client = client;
    }

    public Map<Integer, String> getClients() {
        return clients;
    }

    public void setClients(Map<Integer, String> clients) {
        this.clients = clients;
    }
    
    

    public int getIdinteractions() {
        return idinteractions;
    }

    public void setIdinteractions(int idinteractions) {
        this.idinteractions = idinteractions;
    }

    public boolean isPhone() {
        return Phone;
    }

    public void setPhone(boolean Phonecall) {
        this.Phone = Phonecall;
    }

    public boolean isInPerson() {
        return InPerson;
    }

    public void setInPerson(boolean InPerson) {
        this.InPerson = InPerson;
    }

    public boolean isEmail() {
        return Email;
    }

    public void setEmail(boolean Email) {
        this.Email = Email;
    }

    public boolean isConferenceCall() {
        return ConferenceCall;
    }

    public void setConferenceCall(boolean ConferenceCall) {
        this.ConferenceCall = ConferenceCall;
    }

    public int getTimeOfContact() {
        return TimeOfContact;
    }

    public void setTimeOfContact(int TimeOfContact) {
        this.TimeOfContact = TimeOfContact;
    }
  public Map<Integer,String> getclients() {
        return this.clients;
    }
    
    public void setClient(Map<Integer,String> clients) {
        this.client = client;
    }
   public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.idinteractions + ";");
        buffer.append("TimeOfContact: " + TimeOfContact);
        return buffer.toString();
    }
    
}

