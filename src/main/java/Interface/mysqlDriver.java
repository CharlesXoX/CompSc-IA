/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author charleswong
 */
public class mysqlDriver {
    public static void main(String[] args){
        //cd /usr/local/mysql/bin
        //./mysql -u myuser -p
        /*
        
        
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Enter name: ");
        String getname= sc.nextLine();
        System.out.print("Enter id: ");
        String getid= sc.nextLine();
        
        
        int count = 0;
        String Exists = "false";
        Connection myCon = null;
        //PreparedStatement myStmt = null;
        //ResultSet myRs = null;
        
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        
        
            
            /*
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/TeacherInfo", "myuser" , "xxxx");
            Statement myStmt = myCon.createStatement();
            Statement myStmt2 = myCon.createStatement();
            
            
            
            ResultSet myRs1 = myStmt.executeQuery("select name from Teacher");
            ResultSet myRs2 = myStmt2.executeQuery("select id from Teacher");
            int gg = 0;
            
            while (myRs1.next() && myRs2.next()){
                String Namme = myRs1.getString("name");
                String IDD = myRs2.getString("id");
                if (getname.equals(Namme) && getid.equals(IDD)){
                    gg=1;
                    
                }
                

            }
            if (gg==1){
                System.out.println("Equal");
            }
            else{
                System.out.println("Not Equal");
            }
            */
            
            
        
        
        
            
            /*
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "myuser" , "xxxx");
            myStmt = myCon.prepareStatement("select Testname from test where InvRes = ? ");
           
            myStmt.setString(1, "Porcia");
            
            myRs = myStmt.executeQuery();
            
            
            while (myRs.next()){
                String Title = myRs.getString("Testname");
                System.out.println(Title);
                
            }
            */
            
            

        
            
            
            
            
            
            
            /*
            //get a conncetor 
            

            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/TeacherInfo", "myuser" , "xxxx");
            //create a statement 
            
            Statement myStmt2 = myCon.createStatement();
            Statement myStmt3 = myCon.createStatement();
            //Executen SQL query 
            System.out.println(getname);
            
            ResultSet myRs1 = myStmt2.executeQuery("select name from Teacher");
            while (myRs1.next()){
                String Namme = myRs1.getString("name");
                if (getname.equals(Namme)){
                    Exists = "true";
                    System.out.println("Name already exists");
                }     
            }
            System.out.println(Exists);
            
            ResultSet myRs3 = myStmt2.executeQuery("select id from Teacher");
            while (myRs3.next()){
                if (myRs3.getString("id").equals(getid)){
                    Exists = "true";
                    System.out.println("Id already exists");
                }
            }
            System.out.println(Exists);
            
            
            if ("false".equals(Exists)){    
                
            String sql = "insert into Teacher "
                    + " (id , name)"
                    + " values (?,?)" ;   
            
            myStmt = myCon.prepareStatement("insert into Teacher (id , name) values (?,?)");
            
            myStmt.setString(1, getid);
            myStmt.setString(2, getname);
                       
            
            myStmt.executeUpdate();
            System.out.println("Ran");
            
            }
            else{System.out.println("Already Exists");}
            
            */
            //Prsent the set results
        try{  
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/TeacherInfo", "myuser" , "xxxx");
            Statement myStmt;
            myStmt = myCon.createStatement();
            ResultSet myRs5 = myStmt.executeQuery("select * from Teacher");
            while (myRs5.next()){
                System.out.println(myRs5.getString("id") + ", " + myRs5.getString("name")+", " + myRs5.getString("email"));
            }
            /*
            Connection myCon3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "myuser" , "xxxx");
            Statement myStmt4 = myCon3.createStatement();
            ResultSet myRs6 = myStmt4.executeQuery("select Testdate from test");
            LocalDate mytime = LocalDate.now(); // Create a date object
            DateTimeFormatter myFormattime = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = mytime.format(myFormattime);
            System.out.println(formattedDate);
            while (myRs6.next()){
                System.out.println(myRs6.getString("Testdate") );
                if (myRs6.getString("Testdate")==formattedDate){
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
            */
            
        }
        catch (Exception exc){
            exc.printStackTrace();
            
        }
    }

    
}
