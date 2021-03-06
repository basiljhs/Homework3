/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibuyGUI;

import ibuyGUI.Frames.CoreFrames.UserFrames.BuyerFrame;
import ibuyGUI.UserPermissions.UserLoginException;
import ibuyGUI.UserPermissions.UsersEnum;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Basiljhs
 */
public class MainJframe extends javax.swing.JFrame {

    /**
     * Creates new form MainJframe
     */
    public static UsersEnum currentUser;
    public MainJframe() {
        initComponents();
        currentUser=null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        J_TXT_UserName = new javax.swing.JTextField();
        J_BTN_LogIn = new javax.swing.JButton();
        J_PSD_PassWord = new javax.swing.JPasswordField();
        J_LBL_Error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IBuy");
        setSize(new java.awt.Dimension(0, 0));

        J_TXT_UserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J_TXT_UserName.setText("User name");
        J_TXT_UserName.setToolTipText("Please enter your user name");
        J_TXT_UserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserClicked(evt);
            }
        });
        J_TXT_UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J_TXT_UserNameActionPerformed(evt);
            }
        });

        J_BTN_LogIn.setText("Login");
        J_BTN_LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J_BTN_LogInActionPerformed(evt);
            }
        });

        J_PSD_PassWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        J_PSD_PassWord.setText("password");

        J_LBL_Error.setForeground(new java.awt.Color(255, 51, 51));
        J_LBL_Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(J_LBL_Error, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(J_PSD_PassWord, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(J_TXT_UserName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(J_BTN_LogIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(J_TXT_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(J_PSD_PassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(J_BTN_LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(J_LBL_Error, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        J_TXT_UserName.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void J_TXT_UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J_TXT_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_J_TXT_UserNameActionPerformed

    private void UserClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserClicked
        // TODO add your handling code here:
        if("User name".equals(J_TXT_UserName.getText()))
            J_TXT_UserName.setText("");
    }//GEN-LAST:event_UserClicked

    private void J_BTN_LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J_BTN_LogInActionPerformed
        J_LBL_Error.setText("");
        boolean isError=false;
        try {
            // TODO add your handling code here:
            currentUser=checkUser(J_TXT_UserName.getText(),new String(J_PSD_PassWord.getPassword()));
        } catch (UserLoginException ex) {
            J_LBL_Error.setText(ex.toString());
            isError=true;
            //Logger.getLogger(MainJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!isError)
        {
            this.setVisible(false);
            switch(currentUser){
                case Admin:
                    break;
                case Buyer:break;
            }
            new BuyerFrame().setVisible(true);
        }
        
    }//GEN-LAST:event_J_BTN_LogInActionPerformed
    private UsersEnum checkUser(String user,String psd) throws UserLoginException{
        if(UsersEnum.Admin.getUsername().equals(user))
            if(UsersEnum.Admin.getPassword().equals(psd))
                return UsersEnum.Admin;
        if(UsersEnum.Buyer.getUsername().equals(user))
            if(UsersEnum.Buyer.getPassword().equals(psd))
                return UsersEnum.Buyer;
        if(UsersEnum.Coordinator.getUsername().equals(user))
            if(UsersEnum.Coordinator.getPassword().equals(psd))
                return UsersEnum.Coordinator;
        throw new UserLoginException();
        
        
        
    }
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
            java.util.logging.Logger.getLogger(MainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton J_BTN_LogIn;
    private javax.swing.JLabel J_LBL_Error;
    private javax.swing.JPasswordField J_PSD_PassWord;
    private javax.swing.JTextField J_TXT_UserName;
    // End of variables declaration//GEN-END:variables
}
