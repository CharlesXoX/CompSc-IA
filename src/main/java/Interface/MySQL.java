/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.sql.*;
/**
 *
 * @author charleswong
 */
public class MySQL {
    public static void main(String[] args){
        
        try{
            //get a conncetor 
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "myuser" , "xxxx");
            //create a stament 
            
            //Executen SQL query 
            
        }
        catch (Exception exc){
            exc.printStackTrace();
            
        }
    }
}
