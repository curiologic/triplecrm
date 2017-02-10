/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import crm.clients;
import crm.interactions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author xulix
 */
public class interactionsDAO {
    
     JdbcTemplate template;
    
    private static final Logger logger = Logger.getLogger(interactionsDAO.class.getName());

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public int save(interactions interactions){
        String sql = "INSERT INTO interactions (idinteractions,Time_Of_Contact, In_Person, Phone_call, Email,  Conference_Call) values(?, ?)";

        Object[] values = {interactions.getIdinteractions(), interactions.getTime_Of_Contact(),interactions.isIn_Person(), interactions.isPhone_call(), interactions.isEmail(), interactions.isConference_Call()};
        
        logger.info("interactions DAO save values: " + values);

        return template.update(sql,values);
    }

    public int update(interactions interactions){
        String sql = "UPDATE interactions SET Time_Of_Contact=? WHERE Idinteratcions = ?";

        Object[] values = {interactions.getIdinteractions(), interactions.getTime_Of_Contact(), interactions.isIn_Person(), interactions.isPhone_call(), interactions.isPhone_call(), interactions.isEmail(), interactions.isConference_Call()};

        return template.update(sql,values);
    }

    public int delete(int id){
        String sql = "DELETE FROM interactions WHERE idinteractions = ?";

        Object[] values = {id};

        return template.update(sql,values);
    }

    public List<interactions> getinteractionsList(){
        return template.query("SELECT * FROM interactions",new RowMapper<interactions>(){
            public interactions mapRow(ResultSet rs,int row) throws SQLException{
                interactions it = new interactions();
                it.setIdinteractions(rs.getInt("Idinteractions"));
                it.setTime_Of_Contact(rs.getInt("Time_Of_Contact"));
                it.setIn_Person(true);
                it.setPhone_call(true);
                it.setEmail(true);
                it.setConference_Call(true);
                return it;
            }
        });
    }

    public interactions getinteractionsById(int id){
        String sql = "SELECT Idinteractions AS id, name, idclients FROM interactions WHERE idinteractions = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<interactions>(interactions.class));
    }

    public List<interactions> getinteractionsByPage(int start, int total){
        String sql = "SELECT interactions.idinteractions, interactions.Time_Of_Contact, client.idclients, client.Name " +
                "FROM interactions AS interactions " +
                "INNER JOIN client AS client ON client.idclient = interactions.idclient " +
                "ORDER BY client.Name, interactions.idinteractions " + 
                "LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<interactions>(){
            public interactions mapRow(ResultSet rs,int row) throws SQLException{
                interactions it = new interactions();
                it.setIdinteractions(1);
                it.setTime_Of_Contact(2);
                
                clients client = new clients();
                client.setIdclient(rs.getInt(3));
                client.setName(rs.getString(4));
                
                it.setClient(client);
                return it;
            }
        });
    }
    
    public int getinteractionsCount() {
        String sql = "SELECT COUNT(idinteractions) AS rowcount FROM interactions";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
    
    public Map<Integer,String> getclientsMap() {
        Map<Integer,String> clients = new LinkedHashMap<Integer,String>();
        String sql = "SELECT idclient, Name FROM client ORDER BY Name";
        
        SqlRowSet rs = template.queryForRowSet(sql); 
        
        while(rs.next()){ 
            clients.put(rs.getInt(1), rs.getString(2));
        }
        
        return clients;
    }

    public int save(clients interactions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    

