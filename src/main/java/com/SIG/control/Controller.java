package com.SIG.control;


import com.SIG.model.InvTable;
import com.SIG.model.Invoice;
import com.SIG.model.LinesTable;
import com.SIG.model.Modify;
import com.SIG.view.InvFrame;
import com.SIG.view.InvoiceCode;
import com.SIG.view.ModifyCodes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

public class Controller implements ActionListener, ListSelectionListener {
    private InvFrame frame;
    private InvoiceCode invCode;
    private ModifyCodes modCodes;
    
    public Controller(InvFrame frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String actionCommand = e.getActionCommand();
        System.out.println("Action");
        switch (actionCommand){
                case"Create New Invoice":
                    createNewInvoice();
                    break;
                    case"Delete Invoice":
                        delInvoice();
                        break;
                        case"createInvoiceSave":
                            createInvSave();
                            break;
                            case"createInvoiceCancel":
                                createInvCancel();
                                break;
                                case"createLineSave":
                                    createItemSave();
                                    break;
                                    case"createLineCancel":
                                        createItemCancel();
                                        break;
                        case"Modify":
                            modifyInv();
                            break;
                            case"Delete Item":
                                delItem();
                                break;
                                case"Load File":
                                    loadFile();
                                    break;
                                    case"Save File":
                                        saveFile();
                                        break;
        }                                 
    }

    private void createNewInvoice() {
        invCode = new InvoiceCode(frame);
        invCode.setVisible(true);
    }

    private void delInvoice() {
        int selectedRow = frame.getInvTable().getSelectedRow();
        System.out.println("test");
        if(selectedRow != -1){
            frame.getInvoices().remove(selectedRow);
            frame.getInvoiceTable().fireTableDataChanged();
        }
    }

    private void modifyInv() {
       modCodes = new ModifyCodes(frame);
       modCodes.setVisible(true);
    }

    private void delItem() {
        int selectedInvoice = frame.getInvTable().getSelectedRow();
        int selectedRow = frame.getPresentationTable().getSelectedRow();
                System.out.println("test");
        
        if(selectedInvoice != -1 && selectedRow != -1){
            Invoice invoice = frame.getInvoices().get(selectedInvoice);
            invoice.getLines().remove(selectedRow);
            LinesTable linesTable = new LinesTable(invoice.getLines());
            frame.getPresentationTable().setModel(linesTable);
            linesTable.fireTableDataChanged();
            frame.getInvoiceTable().fireTableDataChanged();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        int selectedIndex = frame.getInvTable().getSelectedRow();
        if(selectedIndex != -1){
        System.out.println("You have selected row: " + selectedIndex);
        Invoice currentInvoice = frame.getInvoices().get(selectedIndex);
        frame.getInvNumLab().setText("" + currentInvoice.getInvNum());
        frame.getInvDateLab().setText("" + currentInvoice.getInvDate());
        frame.getCustomerNameLab().setText("" + currentInvoice.getCustomer());
        frame.getInvTotalLab().setText("" + currentInvoice.getInvTotal());
        LinesTable linesTable = new LinesTable(currentInvoice.getLines());
        frame.getPresentationTable().setModel(linesTable);
        linesTable.fireTableDataChanged();
    }
    }
    
    private void loadFile() {
        JFileChooser fc = new JFileChooser();
        try {
        int result = fc.showOpenDialog(frame);
        if ( result == JFileChooser.APPROVE_OPTION){
            File headerFile = fc.getSelectedFile();
            Path headerPath = Paths.get(headerFile.getAbsolutePath());
            List<String> headerLines = Files.readAllLines(headerPath);
            ArrayList<Invoice> invoicesArray = new ArrayList<>();
            for (String headerLine : headerLines){
                try {
                String[] headerParts = headerLine.split(",");
                int invNum = Integer.parseInt(headerParts[0]);
                String invDate = headerParts[1];
                String customerName = headerParts[2];
              
                Invoice invoice = new Invoice(invNum, invDate, customerName);
                invoicesArray.add(invoice);
                } catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Wrong line format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION){
                File lineFile = fc.getSelectedFile();
                Path linePath = Paths.get(lineFile.getAbsolutePath());
                List<String> modifyLines = Files.readAllLines(linePath);
                for (String modifyLine : modifyLines){
                    try{
                    String lineParts[] = modifyLine.split(",");
                    int invNum = Integer.parseInt(lineParts[0]);
                    String itemName = lineParts[1];
                    double totalPrice = Double.parseDouble(lineParts[2]);
                    int count = Integer.parseInt(lineParts[3]);
                    Invoice inv = null;
                    for (Invoice invoice : invoicesArray){
                        if (invoice.getInvNum() == invNum){
                            inv = invoice;
                            break;
                        }
                    }
                    Modify line = new Modify(itemName, totalPrice, count, inv);
                    inv.getLines().add(line);
                } catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Wrong line format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                }
            frame.setInvoices(invoicesArray);
            InvTable invoiceTable = new InvTable(invoicesArray);
            frame.setInvoiceTable(invoiceTable);
            frame.getInvTable().setModel(invoiceTable);
            frame.getInvoiceTable().fireTableDataChanged();
            }    
            }
                } 
                catch (IOException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Wrong format file", "Error", JOptionPane.ERROR_MESSAGE);
                }
    }

    private void saveFile() {
        ArrayList<Invoice> invs = frame.getInvoices();
        String header = "";
        String lines = "";
        for(Invoice inv : invs){
            String invCSV = inv.getSCV();
            header += invCSV;
            header += "\n";
            
            for (Modify line : inv.getLines()) {
                String lineCSV = line.getSCV();
                lines += lineCSV;
                lines += "\n";
            }
        }
        try {
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION){
            File headerFile = fc.getSelectedFile();
            FileWriter headerFW = new FileWriter(headerFile);
            headerFW.write(header);
            headerFW.flush();
            headerFW.close();
            result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File lineFile = fc.getSelectedFile();
            FileWriter lineFW = new FileWriter(lineFile);
            lineFW.write(lines);
            lineFW.flush();
            lineFW.close();
            }
        }
        } catch (Exception ex){
        }
    }
    
    private void createInvCancel() {
        invCode.setVisible(false);
        invCode.dispose();
        invCode = null;
    }

    private void createInvSave() {
        String invDate = invCode.getInvDateField().getText();
        String customer = invCode.getCustNameField().getText();
        int invNum = frame.getNextInvNum();
        try {
            String[] date = invDate.split("-");
            if(date.length < 3) {
                JOptionPane.showMessageDialog(frame, "Wrong date format","Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int days = Integer.parseInt(date[0]);
                int months = Integer.parseInt(date[1]);
                int years = Integer.parseInt(date[2]);
                if(days > 31 || months > 12){
                    JOptionPane.showMessageDialog(frame, "Wrong date format","Error", JOptionPane.ERROR_MESSAGE);
                } else {
        Invoice inv = new Invoice(invNum, invDate, customer);
        frame.getInvoices().add(inv);
        frame.getInvoiceTable().fireTableDataChanged();
        invCode.setVisible(false);
        invCode.dispose();
        invCode = null;
                }
            }
        } catch (Exception ex){ 
            JOptionPane.showMessageDialog(frame, "Wrong date format","Error", JOptionPane.ERROR_MESSAGE);
        }
        }  

    private void createItemSave() {
        String item = modCodes.getItemNameField().getText();
        String countSt = modCodes.getItemCountField().getText();
        String priceSt = modCodes.getItemPriceField().getText();
        int count = Integer.parseInt(countSt);
        double price = Integer.parseInt(priceSt);
        int selectedInv = frame.getInvTable().getSelectedRow();
        if(selectedInv != -1){
            Invoice inv = frame.getInvoices().get(selectedInv);
            Modify line = new Modify(item, price, count, inv);
            inv.getLines().add(line);
            LinesTable linesTable = (LinesTable) frame.getPresentationTable().getModel();
            linesTable.fireTableDataChanged();
            frame.getInvoiceTable().fireTableDataChanged();
        }
        
        modCodes.setVisible(false);
        modCodes.dispose();
        modCodes = null;
    }

    private void createItemCancel() {
        modCodes.setVisible(false);
        modCodes.dispose();
        modCodes = null;
    }


}
