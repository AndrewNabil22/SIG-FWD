
package com.SIG.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class LinesTable extends AbstractTableModel {
    
    private ArrayList<Modify> lines;
        private String[] columns = {"Num", "Item", "Unit Price", "Qty", "Total Price"};

    public LinesTable(ArrayList<Modify> lines) {
        this.lines = lines;
    }

    public ArrayList<Modify> getLines() {
        return lines;
    }
    
    

    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    public String getColumnName(int column){
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Modify line = lines.get(rowIndex);
        
        switch(columnIndex){
            case 0: return line.getInvoice().getInvNum();
            case 1: return line.getItem();
            case 2: return line.getTotalPrice();
            case 3: return line.getCount();
            case 4: return line.getLineTotal();
            default : return "";
        }
    }
    
}
