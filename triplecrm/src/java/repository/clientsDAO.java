/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import org.springframework.jdbc.core.JdbcTemplate;
import crm.clients;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
/**
 *
 * @author xulix
 */
public class clientsDAO {
     JdbcTemplate template;

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
     public int save(clients client){
        String sql = "INSERT INTO client (idclient,Name, Address, City, State, Country, postalCode, phoneNumber, Email,  prospect, Active, formerClient, Comments)"
               +  " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Object[] values = {client.getIdclient(), client.getName(), client.getAddress(), client.getCity(), client.getState(),  client.getCountry(), client.getpostalCode(),  client.getphoneNumber(), client.getEmail(), client.getProspect(), client.getActive(), client.getformerClient(), client.getComments()};

        return template.update(sql,values);
    }

    public int update(clients client){
        String sql = "UPDATE client SET idclient=?,Name=?, Address=?, City=?, State=?, Country=?, postalCode=?, phoneNumber=?, Email=?, prospect=?, Email=?, Active=?, formerClient=?, Comments=?, WHERE idclient = ?";

        Object[] values = {client.getIdclient(), client.getName(), client.getAddress(), client.getCity(), client.getState(),  client.getCountry(), client.getpostalCode(),  client.getphoneNumber(), client.getEmail(), client.getProspect(), client.getActive(), client.getformerClient(), client.getComments()};

        return template.update(sql,values);
    }

    public int delete(int id){
        String sql = "DELETE FROM client WHERE idclient = ?";

        Object[] values = {id};

        return template.update(sql,values);
    }

    public List<clients> getclientsList(){
        return template.query("SELECT * FROM client",new RowMapper<clients>(){
            public clients mapRow(ResultSet rs,int row) throws SQLException{
                clients c = new clients();
                c.setIdclient(rs.getInt("Idclient"));
                c.setName(rs.getString("Name"));
                c.setAddress(rs.getString("Address"));
                c.setCity(rs.getString("City"));
                c.setpostalCode(rs.getString("PostalCode"));
                c.setState(rs.getString("State"));
                c.setProspect(rs.getString("Prospect"));
                c.setCountry(rs.getString("Country"));
                c.setphoneNumber(rs.getInt("PhoneNumber"));
                c.setEmail(rs.getString("Email"));
                c.setActive(rs.getBoolean("Active"));
                c.setformerClient(rs.getBoolean("FormerClient"));
                c.setComments(rs.getString("Comments"));
                return c;
            }
        });
    }

    public clients getclientsById(int id){
        String sql = "SELECT idclient AS id, Name FROM client WHERE idclient = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<clients>(clients.class));
    }

    public List<clients> getclientsByPage(int start, int total){
        String sql = "SELECT * FROM client LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<clients>(){
            public clients mapRow(ResultSet rs,int row) throws SQLException{
                clients c = new clients();
                c.setIdclient(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setAddress(rs.getString("Address"));
                c.setCity(rs.getString("City"));
                c.setpostalCode(rs.getString("PostalCode"));
                c.setState(rs.getString("State"));
                c.setProspect(rs.getString("Prospect"));
                c.setCountry(rs.getString("Country"));
                c.setphoneNumber(rs.getInt("PhoneNumber"));
                c.setEmail(rs.getString("Email"));
                c.setActive(rs.getBoolean("Active"));
                c.setformerClient(rs.getBoolean("FormerClient"));
                c.setComments(rs.getString("Comments"));
                return c;
            }
        });
    }
    
    public int getclientsCount() {
        String sql = "SELECT COUNT(idclient) AS rowcount FROM client";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
    
    
}
