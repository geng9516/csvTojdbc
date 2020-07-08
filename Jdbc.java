/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.jp.tihtih.homework;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Jdbc {
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;
   
   String DB_URL = "jdbc:postgresql://localhost:5432/contact";
   String USER = "postgres";
   String PASS = "postgres";
   
   public Connection getDbcom() throws ClassNotFoundException{
      if(conn == null){
          Class.forName("org.postgresql.Driver");
          try {
              conn = DriverManager.getConnection(DB_URL, USER,PASS);
              stmt = conn.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
       return conn; 
   }
   public void closeDbcom() throws SQLException{
       if(conn != null){
           stmt.close();
           conn.close();
       }
   }
   
   public int addContact (Company com) throws SQLException{
       String sql = "insert into userinfo (id,katagaki,name,email)";
       sql += "values(" + Integer.parseInt(com.getID()) + ",";
       sql += "'" + com.getKatagaki() + "',";
       sql += "'" + com.getName() + "',";
       sql += "'" + com.getEmail() + "')";
       stmt.executeUpdate(sql);
       System.out.println(sql);

 
       return 1;
   }
}
