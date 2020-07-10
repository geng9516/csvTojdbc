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
import java.util.ArrayList;
import java.util.List;
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

    public Connection getDbcom() throws ClassNotFoundException {
        if (conn == null) {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    public void closeDbcom() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public int addContact(Company com) throws SQLException {
        String sql = "insert into userinfo (id,katagaki,name,email)";
        sql += "values(" + Integer.parseInt(com.getID()) + ",";
        sql += "'" + com.getKatagaki() + "',";
        sql += "'" + com.getName() + "',";
        sql += "'" + com.getEmail() + "')";
        stmt.executeUpdate(sql);
        System.out.println(sql);

        return 1;
    }

    public void UpdateDb(Company com) throws SQLException {
        String sql = "update userinfo set";
        sql += " katagaki=" + "'" + com.getKatagaki() + "',";
        sql += "name=" + "'" + com.getName() + "',";
        sql += "email=" + "'" + com.getEmail() + "'";
        sql += " where id=";
        sql += "'" + com.getID() + "'";
        stmt.executeUpdate(sql);
        System.out.println(sql);
    }

    public List<Company> selectUserinfo() throws SQLException {
        List<Company> list = new ArrayList<>();
        String sql = "select * from userinfo";

        rs = stmt.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {

                Company com = new Company();
                com.setID(rs.getString(1));
                com.setKatagaki(rs.getString(2));
                com.setName(rs.getString(3));
                com.setEmail(rs.getString(4));
                list.add(com);
            }
        }
        return list;

    }

    public int userinfoId(int res) throws SQLException {
        String sql = "select * from userinfo where id = " + res;
        System.out.println(sql);
        rs = stmt.executeQuery(sql);
        int result = 0;
        if (rs != null) {
            while (rs.next()) {
                return result = 1;
            }
        }
        return 0;
    }
}
