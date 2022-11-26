
package com.SIG.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModifyCodes extends JDialog{
    private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField itemPriceField;
    private JLabel itemNameLab;
    private JLabel itemCountLab;
    private JLabel itemPriceLab;
    private JButton saveBtn;
    private JButton cancelBtn;
    
    public ModifyCodes(InvFrame frame) {
        itemNameField = new JTextField(20);
        itemNameLab = new JLabel("Item Name");
        
        itemCountField = new JTextField(20);
        itemCountLab = new JLabel("Item Count");
        
        itemPriceField = new JTextField(20);
        itemPriceLab = new JLabel("Item Price");
        
        saveBtn = new JButton("Save!");
        cancelBtn = new JButton("Cancel X");
        
        saveBtn.setActionCommand("createLineSave");
        cancelBtn.setActionCommand("createLineCancel");
        
        saveBtn.addActionListener(frame.getController());
        cancelBtn.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLab);
        add(itemNameField);
        add(itemCountLab);
        add(itemCountField);
        add(itemPriceLab);
        add(itemPriceField);
        add(saveBtn);
        add(cancelBtn);
        
        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }
}
