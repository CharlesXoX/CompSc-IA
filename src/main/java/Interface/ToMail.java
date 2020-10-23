/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author charleswong
 */
public class ToMail extends javax.swing.JFrame {
    String Testname;
    String Tid;
    /**
     * Creates new form NewJFrame
     */
    public ToMail(String Tid, String Testname) {
        initComponents();
        this.Tid = Tid;
        jTextField_TestTitle.setText(Testname);
        
        try {
            Connection myConinit = DriverManager.getConnection("jdbc:mysql://localhost:3306/Testinfo", "myuser" , "xxxx");
            PreparedStatement myStmtinit = null;
            myStmtinit = myConinit.prepareStatement("select Creator from test where InvRes = ?");
            myStmtinit.setString(1, Tid);
            ResultSet myRsinit = myStmtinit.executeQuery();
            while (myRsinit.next()){
                String Cid = myRsinit.getString("Creator");
                Connection myCon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Teacherinfo", "myuser" , "xxxx");
                PreparedStatement myStmt2 = null;
                myStmt2 = myCon2.prepareStatement("select email from teacher where id = ?");
                myStmt2.setString(1, Cid);
                ResultSet myRs2 = myStmt2.executeQuery();
                while (myRs2.next()){
                    String Cmail = myRs2.getString("email"); 
                    jTextField_TestTeacher.setText(Cmail);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_TestTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Qno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_TestTeacher = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton_Send = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton_Return = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField_TeacherPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Send an Email to the Test Creator");

        jLabel2.setText("Title of Test:");

        jTextField_TestTitle.setText("<Auto Enter Test Title>");
        jTextField_TestTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TestTitleActionPerformed(evt);
            }
        });

        jLabel3.setText("Question Number:");

        jTextField_Qno.setText("<Please Enter Question Number>");

        jLabel4.setText("Will be sent to:");

        jTextField_TestTeacher.setText("<Auto Enter Paper Maker>");
        jTextField_TestTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TestTeacherActionPerformed(evt);
            }
        });

        jLabel5.setText("Brief description of the Problem:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton_Send.setText("Send");
        jButton_Send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SendMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(314, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel6.setText("Attachement (If needed):");

        jButton_Return.setText("Return");
        jButton_Return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ReturnMouseClicked(evt);
            }
        });

        jLabel7.setText("Password for registered mail:");

        jTextField_TeacherPassword.setText("<Please Enter Mail Password>");
        jTextField_TeacherPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TeacherPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7))
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField_Qno)
                                        .addComponent(jTextField_TestTitle)
                                        .addComponent(jTextField_TestTeacher)
                                        .addComponent(jTextField_TeacherPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(81, 81, 81))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton_Return)
                                        .addGap(58, 58, 58)))
                                .addComponent(jButton_Send)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_TestTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Qno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_TestTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_TeacherPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Send)
                    .addComponent(jButton_Return))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_TestTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TestTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TestTitleActionPerformed

    private void jTextField_TestTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TestTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TestTeacherActionPerformed

    private void jButton_SendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SendMouseClicked
        try {
            // finding inv email
            
            String Invemail = null;
            int checking = 0;
            Connection myConinit = DriverManager.getConnection("jdbc:mysql://localhost:3306/TeacherInfo", "myuser" , "xxxx");
            PreparedStatement myStmtinit = null;
            myStmtinit = myConinit.prepareStatement("select email from teacher where id = ?");
            myStmtinit.setString(1, Tid);
            ResultSet myRsinit = myStmtinit.executeQuery();
            
            
            while (myRsinit.next()){
                checking ++;
                
                Invemail = myRsinit.getString("email");
                System.out.println(Invemail);
                
                // filling information for email, use me for now
                String to = jTextField_TestTeacher.getText();
                System.out.println(to);
                to = "s1304002@elear.logosacademy.edu.hk";

                final String from = Invemail;
                System.out.println(from);
                
                final String tempfrom = "charleswongxox@gmail.com";
                
                final String password = jTextField_TeacherPassword.getText();
                System.out.println(password);
                
                String host = "smtp.gmail.com";
                Properties properties = System.getProperties();

                properties.put("mail.smtp.host", host);
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");

                    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

                        protected PasswordAuthentication getPasswordAuthentication() {

                            return new PasswordAuthentication(tempfrom /* from */ , password);

                        }

                    });

                    session.setDebug(true);

                try {

                    MimeMessage message = new MimeMessage(session);


                    message.setFrom(new InternetAddress(from));


                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                    // Set Subject: header field
                    String Subject = jTextField_TestTitle.getText();
                    message.setSubject(Subject);

                    // Now set the actual message
                    String Qno = jTextField_Qno.getText();
                    String Text = jTextArea1.getText();
                    message.setText("Question number: " + Qno + ". Problem:" + Text);
 
                    System.out.println("sending...");
                    // Send message
                    Transport.send(message);
                    System.out.println("Sent message successfully....");
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
            }
            if (checking == 0){
                System.out.println("User have not added email");
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        /*
        System.out.println("Start Disposing");
        dispose();
        System.out.println("closing...");
        MainScreen MS = new MainScreen(Tid);
        MS.setVisible(true); 
        */
        //Answering ANS = new Answering();
    }//GEN-LAST:event_jButton_SendMouseClicked

    private void jTextField_TeacherPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TeacherPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TeacherPasswordActionPerformed

    private void jButton_ReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ReturnMouseClicked
        // TODO add your handling code here:
    dispose();
        System.out.println("closing...");
        MainScreen MS = new MainScreen(Tid);
        MS.setVisible(true);    
    }//GEN-LAST:event_jButton_ReturnMouseClicked

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
            java.util.logging.Logger.getLogger(ToMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToMail("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_Return;
    private javax.swing.JButton jButton_Send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField_Qno;
    private javax.swing.JTextField jTextField_TeacherPassword;
    private javax.swing.JTextField jTextField_TestTeacher;
    private javax.swing.JTextField jTextField_TestTitle;
    // End of variables declaration//GEN-END:variables
}
