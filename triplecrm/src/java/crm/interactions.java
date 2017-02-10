/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author xulix
 */
public class interactions implements Serializable  {
    private int idinteractions;
    private boolean Phone_call;
    private boolean In_Person;
    private boolean Email;
    private boolean Conference_Call;
    private int Time_Of_Contact;
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

    public boolean isPhone_call() {
        return Phone_call;
    }

    public void setPhone_call(boolean Phone_call) {
        this.Phone_call = Phone_call;
    }

    public boolean isIn_Person() {
        return In_Person;
    }

    public void setIn_Person(boolean In_Person) {
        this.In_Person = In_Person;
    }

    public boolean isEmail() {
        return Email;
    }

    public void setEmail(boolean Email) {
        this.Email = Email;
    }

    public boolean isConference_Call() {
        return Conference_Call;
    }

    public void setConference_Call(boolean Conference_Call) {
        this.Conference_Call = Conference_Call;
    }

    public int getTime_Of_Contact() {
        return Time_Of_Contact;
    }

    public void setTime_Of_Contact(int Time_Of_Contact) {
        this.Time_Of_Contact = Time_Of_Contact;
    }

   public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.idinteractions + ";");
        buffer.append("Time_Of_Contact: " + Time_Of_Contact);
        return buffer.toString();
    }
    
}

