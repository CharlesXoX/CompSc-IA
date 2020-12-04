/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author charleswong
 */
public class MainScreen extends javax.swing.JFrame {
    String Tid;
    /**
     * Creates new form NewJFrame1
     * @param Tid
     */
    public MainScreen(String Tid) {
        initComponents();
        this.Tid = Tid;
        
        //set page username
        try {
            Connection myConinit = DriverManager.getConnection("jdbc:mysql://localhost:3306/Teacherinfo", "myuser" , "xxxx");
            PreparedStatement myStmtinit = null;
            myStmtinit = myConinit.prepareStatement("select name from teacher where id = ?");
            myStmtinit.setString(1, Tid);
            ResultSet myRsinit = myStmtinit.executeQuery();
            
            // check date
            while (myRsinit.next()){
                String Uname = myRsinit.getString("name");
                jLabel3_Username.setText(Uname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        LocalDate mytime = LocalDate.now(); // Create a date object
        DateTimeFormatter myFormattime = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = mytime.format(myFormattime);
        jLabel3_CurrentTime.setText(formattedDate);

        
        Connection myCon = null;
        Connection myCon2 = null;
        PreparedStatement myStmt = null;
        PreparedStatement myStmt2 = null;
        PreparedStatement myStmt3 = null;
        PreparedStatement myStmt4 = null;
        ResultSet myRs = null;
        ResultSet myRs2 = null;
        ResultSet myRs3 = null;
        ResultSet myRs4 = null;
        
        try{
            // fill in test name
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "myuser" , "xxxx");
            myStmt = myCon.prepareStatement("select Testname from test where InvRes = ? ");
            myStmt.setString(1, Tid);
            myRs = myStmt.executeQuery();
            

            // check date
            while (myRs.next()){
                String Title = myRs.getString("Testname");



                myCon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "myuser" , "xxxx");
                myStmt3 = myCon2.prepareStatement("select Testdate from test where Testname = ?");
                myStmt3.setString(1, Title);
                myRs3 = myStmt3.executeQuery();


                while (myRs3.next()){
                    System.out.println(formattedDate);
                    String Date = myRs3.getString("Testdate");
                    System.out.println(Date);

                    if (Date.equals(formattedDate)){

                            //String Title = myRs.getString("Testname");


                            jLabel4_TestTitle.setText(Title);
                            myStmt2 = myCon.prepareStatement("select Testtime from test where InvRes = ? ");
                            myStmt2.setString(1, Tid);
                            myRs2 = myStmt2.executeQuery();

                            while (myRs2.next()){

                                String Timefrom = myRs2.getString("Testtime");
                                Pattern pattern = Pattern.compile("[^-]*");
                                Matcher matcher = pattern.matcher(Timefrom);
                                if (matcher.find()){
                                    jLabel3_TimeFrom.setText(matcher.group());
                                }
                                Pattern pattern2 = Pattern.compile("[^-]*$");
                                Matcher matcher2 = pattern2.matcher(Timefrom);
                                if (matcher2.find()){
                                    jLabel6_TimeTo.setText(matcher2.group());
                                }
                            } 

                            myStmt4 = myCon.prepareStatement("select Testroom from test where InvRes = ? ");
                            myStmt4.setString(1, Tid);
                            myRs4 = myStmt4.executeQuery();
                            while (myRs4.next()){
                                String Testroom = myRs4.getString("Testroom");
                                jLabel6_TestRoom.setText(Testroom);

                            }
                    }
                    else {
                        jLabel4_TestTitle.setText("No Test Now");;
                    }
                }
            }         
        //[^-]*-
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3_Username = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4_TestTitle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6_TestRoom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3_TimeFrom = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6_TimeTo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_Help = new javax.swing.JButton();
        jButton_SendEmail = new javax.swing.JButton();
        jButton_Refresh = new javax.swing.JButton();
        jLabel3_CurrentTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //String Name = Uname;

        jLabel1.setText("You are invigilating test:");

        jLabel4_TestTitle.setText("<Test>");

        jLabel5.setText("In room: ");

        jLabel6_TestRoom.setText("<TestRoom>");

        jLabel2.setText("from");

        jLabel3_TimeFrom.setText("<TimeFrom>");

        jLabel4.setText(":");

        jLabel6_TimeTo.setText("<TimeTo>");

        jButton_Help.setText("Call Help");
        jButton_Help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_HelpMouseClicked(evt);
            }
        });
        jButton_Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HelpActionPerformed(evt);
            }
        });

        jButton_SendEmail.setText("Send Email ");
        jButton_SendEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SendEmailMouseClicked(evt);
            }
        });
        jButton_SendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SendEmailActionPerformed(evt);
            }
        });

        jButton_Refresh.setText("Refresh");
        jButton_Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_RefreshMouseClicked(evt);
            }
        });

        jLabel3_CurrentTime.setText("<Current Time>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6_TestRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4_TestTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3_Username)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3_CurrentTime))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Help, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3_TimeFrom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6_TimeTo))
                            .addComponent(jButton_SendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Refresh)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3_Username)
                    .addComponent(jLabel3_CurrentTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4_TestTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6_TestRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3_TimeFrom)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6_TimeTo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jButton_Help, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_SendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton_Refresh)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_HelpActionPerformed

    private void jButton_SendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SendEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SendEmailActionPerformed

    private void jButton_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RefreshMouseClicked

        dispose();
        MainScreen MS2 = new MainScreen(Tid);
        MS2.setVisible(true);
        
    }//GEN-LAST:event_jButton_RefreshMouseClicked

    private void jButton_HelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_HelpMouseClicked
        // TODO add your handling code here:
        ContactList CL = new ContactList(Tid);
        CL.setVisible(true);  
        
    }//GEN-LAST:event_jButton_HelpMouseClicked

    private void jButton_SendEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SendEmailMouseClicked
        // TODO add your handling code here:
        String Testname = jLabel4_TestTitle.getText(); 
        System.out.println("Send Mail Clicked");
        dispose();
        ToMail NM = new ToMail(Tid, Testname);
        NM.setVisible(true);
        
       
    }//GEN-LAST:event_jButton_SendEmailMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Help;
    private javax.swing.JButton jButton_Refresh;
    private javax.swing.JButton jButton_SendEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3_CurrentTime;
    private javax.swing.JLabel jLabel3_TimeFrom;
    private javax.swing.JLabel jLabel3_Username;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4_TestTitle;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6_TestRoom;
    private javax.swing.JLabel jLabel6_TimeTo;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconframe.png")));
    }
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
    return new ImageIcon(resizedImage);
}
   
}   

