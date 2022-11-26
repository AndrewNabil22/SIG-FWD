package com.SIG.view;

import com.SIG.control.Controller;
import com.SIG.model.InvTable;
import com.SIG.model.Invoice;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTable;

public class InvFrame extends javax.swing.JFrame {

    public InvFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invTable = new javax.swing.JTable();
        invTable.getSelectionModel().addListSelectionListener(controller);
        jScrollPane2 = new javax.swing.JScrollPane();
        presentationTable = new javax.swing.JTable();
        invNumber = new javax.swing.JLabel();
        invDate = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        invTotal = new javax.swing.JLabel();
        createInvButton = new javax.swing.JButton();
        createInvButton.addActionListener(controller);
        delInvButton = new javax.swing.JButton();
        delInvButton.addActionListener(controller);
        modifyButton = new javax.swing.JButton();
        modifyButton.addActionListener(controller);
        delItemButton = new javax.swing.JButton();
        delItemButton.addActionListener(controller);
        invNumLab = new javax.swing.JLabel();
        invDateLab = new javax.swing.JLabel();
        customerNameLab = new javax.swing.JLabel();
        invTotalLab = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFileMenu = new javax.swing.JMenuItem();
        loadFileMenu.addActionListener(controller);
        saveFileMenu = new javax.swing.JMenuItem();
        saveFileMenu.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invTable);

        presentationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(presentationTable);

        invNumber.setText("Invoice Number");

        invDate.setText("Invoice Date");

        customerName.setText("Customer Name");

        invTotal.setText("Invoice Total");

        createInvButton.setText("Create New Invoice");
        createInvButton.setAutoscrolls(true);
        createInvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvButtonActionPerformed(evt);
            }
        });

        delInvButton.setText("Delete Invoice");

        modifyButton.setText("Modify");

        delItemButton.setText("Delete Item");

        jMenu1.setText("File");

        loadFileMenu.setText("Load File");
        jMenu1.add(loadFileMenu);

        saveFileMenu.setText("Save File");
        saveFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveFileMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invNumber)
                            .addComponent(invDate)
                            .addComponent(customerName)
                            .addComponent(invTotal))
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(invNumLab)
                            .addComponent(invDateLab)
                            .addComponent(customerNameLab)
                            .addComponent(invTotalLab))))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(createInvButton)
                .addGap(131, 131, 131)
                .addComponent(delInvButton)
                .addGap(74, 74, 74)
                .addComponent(modifyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delItemButton)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invNumber)
                            .addComponent(invNumLab))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invDate)
                            .addComponent(invDateLab))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerName)
                            .addComponent(customerNameLab))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invTotal)
                            .addComponent(invTotalLab))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvButton)
                    .addComponent(delInvButton)
                    .addComponent(modifyButton)
                    .addComponent(delItemButton))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createInvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvButtonActionPerformed

    }//GEN-LAST:event_createInvButtonActionPerformed

    private void saveFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFileMenuActionPerformed

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
            java.util.logging.Logger.getLogger(InvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvButton;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel customerNameLab;
    private javax.swing.JButton delInvButton;
    private javax.swing.JButton delItemButton;
    private javax.swing.JLabel invDate;
    private javax.swing.JLabel invDateLab;
    private javax.swing.JLabel invNumLab;
    private javax.swing.JLabel invNumber;
    private javax.swing.JTable invTable;
    private javax.swing.JLabel invTotal;
    private javax.swing.JLabel invTotalLab;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFileMenu;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTable presentationTable;
    private javax.swing.JMenuItem saveFileMenu;
    // End of variables declaration//GEN-END:variables
private ArrayList<Invoice> invoices;
private Controller controller = new Controller(this);
private InvTable invoiceTable;

 
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public InvTable getInvoiceTable() {
        return invoiceTable;
    }

    public void setInvoiceTable(InvTable invoiceTable) {
        this.invoiceTable = invoiceTable;
    }

    public JLabel getCustomerNameLab() {
        return customerNameLab;
    }

    public JLabel getInvDateLab() {
        return invDateLab;
    }

    public JLabel getInvNumLab() {
        return invNumLab;
    }

    public JTable getInvTable() {
        return invTable;
    }

    public JLabel getInvTotalLab() {
        return invTotalLab;
    }

    public JTable getPresentationTable() {
        return presentationTable;
    }

    public Controller getController() {
        return controller;
    }

    public JLabel getCustomerName() {
        return customerName;
    }

    public JLabel getInvDate() {
        return invDate;
    }

    public JLabel getInvNumber() {
        return invNumber;
    }

    public JLabel getInvTotal() {
        return invTotal;
    }
    
    public int getNextInvNum(){
int num = 0;
for (Invoice inv : invoices){
if(inv.getInvNum() > num)
    num = inv.getInvNum();
}
return ++num;
}

}