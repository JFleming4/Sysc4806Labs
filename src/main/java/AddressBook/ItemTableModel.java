package AddressBook;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ItemTableModel extends AbstractTableModel {
    AddressBook book;

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public int getColumnCount() {
        return 1;
    }

    public String getColumnName(int column) {
        return "Items";
    }

    public void setItemList(AddressBook book) {
        this.book = book;
    }

    public int getRowCount() {
        return book.getSize();
    }

//    public void setValueAt(Object value,
//                           int rowIndex, int columnIndex) {
//        itemList.set(rowIndex, value);
//    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return book.getBuddyAt(rowIndex);
    }
}
