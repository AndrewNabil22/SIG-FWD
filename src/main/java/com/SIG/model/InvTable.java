
package com.SIG.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvTable extends AbstractTableModel {
    private ArrayList<Invoice> invoices;
    
    private String[] columns = {"Num", "Date", "Customer", "Total"};

    public InvTable(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column){
        return columns[column];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice inv = invoices.get(rowIndex);
        switch (columnIndex) {
            case 0: return inv.getInvNum();
            case 1: return inv.getInvDate();
            case 2: return inv.getCustomer();
            case 3: return inv.getInvTotal();
            default : return "Error";
        }
    }
}
