package com.SIG.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvoiceCode extends JDialog {
    private JTextField custNameField;
    private JTextField invDateField;
    private JLabel customerNameLab;
    private JLabel invDateLab;
    private JButton saveBtn;
    private JButton cancelBtn;

    public InvoiceCode(InvFrame frame) {
        customerNameLab = new JLabel("Customer Name:");
        custNameField = new JTextField(20);
        invDateLab = new JLabel("Invoice Date:");
        invDateField = new JTextField(20);
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");
        
        saveBtn.setActionCommand("createInvoiceSave");
        cancelBtn.setActionCommand("createInvoiceCancel");
        
        saveBtn.addActionListener(frame.getController());
        cancelBtn.addActionListener(frame.getController());
        setLayout(new GridLayout(3, 2));
        
        add(invDateLab);
        add(invDateField);
        add(customerNameLab);
        add(custNameField);
        add(saveBtn);
        add(cancelBtn);
        
        pack();
        
    }

    public JTextField getCustNameField() {
        return custNameField;
    }

    public JTextField getInvDateField() {
        return invDateField;
    }
    
}
