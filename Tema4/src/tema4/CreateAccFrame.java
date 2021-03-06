/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;



/**
 *
 * @author Ariana
 */
public class CreateAccFrame extends javax.swing.JFrame {
    static Bank bank= new Bank();
    /**
     * Creates new form CreateAccFrame
     */
    public CreateAccFrame() {
        initComponents();
    }

    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        cnpField = new javax.swing.JTextField();
        adressField = new javax.swing.JTextField();
        SavingAcc = new javax.swing.JRadioButton();
        SpendingAcc = new javax.swing.JRadioButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Complete all the fields:");

        jButton1.setText("Create!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        jLabel3.setText("CNP:");

        jLabel4.setText("Address:");

        adressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adressFieldActionPerformed(evt);
            }
        });

        buttonGroup1.add(SavingAcc);
        SavingAcc.setText("Saving Account");
        SavingAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavingAccActionPerformed(evt);
            }
        });

        buttonGroup1.add(SpendingAcc);
        SpendingAcc.setText("Spending Account");

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SavingAcc)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addComponent(SpendingAcc))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(cnpField)
                                    .addComponent(adressField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cnpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(79, 79, 79)
                .addComponent(SavingAcc)
                .addGap(18, 18, 18)
                .addComponent(SpendingAcc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(close))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String name,cnp,adress,type="",pin="1000";
        name=nameField.getText();
        if(name.isEmpty())
            JOptionPane.showMessageDialog(null, "Introduce your name!");
        cnp=cnpField.getText();
        if(cnp.isEmpty())
            JOptionPane.showMessageDialog(null, "Introduce your cnp!");
        adress=adressField.getText();
         if(adress.isEmpty())
            JOptionPane.showMessageDialog(null, "Introduce your address!");
         int ok=1;
         for(int i=0;i<cnp.length();i++)
            if(cnp.charAt(i)<'0' || cnp.charAt(i)>'9' || cnp.length()!=13){
                
                ok=0;
            }
        
        if(ok==1){
        Person client;
        
        while(bank.existPIN(pin)){
            int n=Integer.parseInt(pin);
            n++;
            pin=Integer.toString(n);
        }
        
        if(SavingAcc.isSelected())
            type="SavingAccount";
        if(SpendingAcc.isSelected())
            type="SpendingAccount";
        
        client= new Person(name,adress,cnp);
        
        if (type.compareTo("SavingAccount")==0)
                 {
                    SavingAccount sa= new SavingAccount(pin,client,type,0);
                    bank.createSavingAccount(sa);
                 }
        else{
                     if (type.compareTo("SpendingAccount")==0)
                     {
                        SpendingAccount spa = new SpendingAccount(pin,client,type,0);
                        bank.createSpendingAccount(spa);
                     }
                     else{
                         JOptionPane.showMessageDialog(null,"Select a type!");
                     }
        }
        
        JOptionPane.showMessageDialog(null,"Your PIN is "+pin);
        }
        else
             JOptionPane.showMessageDialog(null,"Your personal data are wrong!");
      
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void adressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adressFieldActionPerformed

    private void SavingAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavingAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SavingAccActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
          close();
    }//GEN-LAST:event_closeActionPerformed

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
            java.util.logging.Logger.getLogger(CreateAccFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton SavingAcc;
    private javax.swing.JRadioButton SpendingAcc;
    private javax.swing.JTextField adressField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton close;
    private javax.swing.JTextField cnpField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
