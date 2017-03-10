/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import crm.clients;
import crm.interactions;
import crm.users;
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
public class usersDAO {
      JdbcTemplate template;
    
    private static final Logger logger = Logger.getLogger(usersDAO.class.getName());

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save(users user){
        String sql = "INSERT INTO users (UserName, password) values(?, md5(?))";

        Object[] values = {user.getUserName(), user.getPassword()};
        
        logger.info("User DAO save values: " + values);
        
        int r = template.update(sql,values);
        
        sql = "INSERT INTO users (username, role) VALUES (?, ?)";
        
        for (String role: user.getRoles()) {
            Object[] role_values = {user.getUserName(), role};
            
            logger.info("User DAO add role: " + values);
            
            template.update(sql, role_values);
        }

        // for this example we are going to return the insert of the user. 
        // we could do some more work here to make sure the roles went in, 
        // but the user is what is important.
        return r;
    }
     public int update(users users){
        String sql = "UPDATE users SET Idusers=? UserName=?, Password=?, Roles=? WHERE Idusers = ?";

        Object[] values = {users.getIdusers(), users.getUserName(), users.getPassword(), users.getRoles(), users.getRolemap()};

        return template.update(sql,values);
    }

    public int delete(int id){
        String sql = "DELETE FROM users WHERE idusers = ?";

        Object[] values = {id};

        return template.update(sql,values);
    }

    public List<users> getusersList(){
        return template.query("SELECT * FROM users",new RowMapper<users>(){
            public users mapRow(ResultSet rs,int row) throws SQLException{
                users us = new users();
                us.setIdusers(rs.getInt("Idusers"));
                us.setUserName(rs.getString("UserName"));
                us.setPassword(rs.getString("Password"));
                 us.setEnabled(rs.getBoolean("Enabled"));
                return us;
            }
        });
    }

    public users getusersById(int id){
        String sql = "SELECT Idusers AS id,  FROM users WHERE idusers = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<users>(users.class));
    }

    public List<users> getusersByPage(int start, int total){
        String sql = "SELECT * FROM users LIMIT "              
                 + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<users>(){
            public users mapRow(ResultSet rs,int row) throws SQLException{
                users us = new users();
                us.setIdusers(rs.getInt(1));
                us.setUserName(rs.getString(2));
               us.setPassword(rs.getString(3));
               us.setEnabled(rs.getBoolean(4));
                return us;
            }
        });
    }
    
    public int getusersCount() {
        String sql = "SELECT COUNT(idusers) AS rowcount FROM users";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
}
    
   

    

