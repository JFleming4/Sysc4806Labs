package AddressBook;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class BoxLayoutPanel extends JPanel {
    private List panelComponents;
    private int axis;
    public void setAxis(int axis) {
        this.axis = axis;
    }

    public List getPanelComponents() {
        return panelComponents;
    }

    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    public int getAxis() {
        return axis;
    }

    public void init() {
        setLayout(new BoxLayout(this, axis));

        for(Iterator iter = panelComponents.iterator(); iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component);
        }
    }

}
