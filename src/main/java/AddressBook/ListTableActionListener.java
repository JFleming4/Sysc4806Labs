package AddressBook;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class ListTableActionListener
        implements ActionListener {
    protected JTable table;
    protected AddressBook book;

    public void setList(AddressBook book) {
        this.book = book;
    }

    public void setTable(JTable itemTable) {
        this.table = itemTable;
    }
}
