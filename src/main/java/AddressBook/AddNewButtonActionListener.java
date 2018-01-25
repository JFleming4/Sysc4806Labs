package AddressBook;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class AddNewButtonActionListener extends
        ListTableActionListener {
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Input name");
        String number = JOptionPane.showInputDialog("Input number");
        book.addBuddy(new BuddyInfo(name, number));
        table.revalidate();
    }
}
