/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author trant
 */
public class LoginController {
  
     private static final String DATABASE_URL = "jdbc:mysql://localhost/miniproject?serverTimezone=UTC";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "";
  
    public LoginController() {
    }
   
    public static Connection DBConnect(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
             
            return con;
        } catch (Exception e) {
            System.out.println("Fail :<");
        }
        return null;
    }
    public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException{
      
           Connection conn= DBConnect();
          Statement stm= conn.createStatement();
            String sql= "Select * from nhanvien where username='"+username+"' and password='"+password+"'";
                    ResultSet rs = stm.executeQuery(sql);
 
                  if (rs.next() ) {
                      System.out.println("Successfull !!!");
                      return true;
                        }
                  else{
                      System.out.println("Fail :<");
                  }    
                 return false;
                    
                }    
    
    public static void main(String[] args) {
        LoginForm lg= new LoginForm();
       lg.show();
        
    }

    
}
