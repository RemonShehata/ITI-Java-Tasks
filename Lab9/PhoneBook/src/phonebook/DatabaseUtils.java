/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author remon
 */
public class DatabaseUtils {

    public static Connection con = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    public static void init() {
        try {
            if (con == null || con.isClosed()) {
                try {
                    DriverManager.registerDriver(new ClientDriver());
                    con = DriverManager.getConnection("jdbc:derby://localhost:1527/PhoneBook", "root", "root");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeResources() {
        try {
            if (!(con == null || con.isClosed())) {
                try {
                    stmt.close();
                    con.close();
                    rs.close();
                    rs = null;
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getResults(String queryString) {
        init();
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(queryString);
            /*stmt.close();
            con.close();*/
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addField(String name, String phone) {
        init();
        try {
            PreparedStatement pst = con.prepareStatement("insert into CONTACT values(?,?)");
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void updateField(String name, String phone, String oldPhone) {
        init();
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE CONTACT set name = ?, phone = ? WHERE phone = ?");
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, oldPhone);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void deleteField(String phone) {
        init();
        try {
            System.out.println("delete field  " + phone);
            PreparedStatement pst = con.prepareStatement("DELETE FROM CONTACT WHERE phone = ?");
            pst.setString(1, phone);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
