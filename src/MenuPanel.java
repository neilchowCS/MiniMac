import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JMenuBar {
    public MenuPanel(ControlPanel p) {
        JMenu fileMenu = makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, p);
        this.add(fileMenu);
        JMenu editMenu = makeMenu("Edit", new String[]{"Parse", "Run", "Clear"}, p);
        this.add(editMenu);
        JButton helpMenu = new JButton("Help");
        helpMenu.addActionListener(p);
        this.add(helpMenu);
    }
    private JMenu makeMenu(String name, String[] items, ActionListener handler) {
        JMenu result = new JMenu(name);
        for(int i = 0; i < items.length; i++) {
            JMenuItem item = new JMenuItem(items[i]);
            item.addActionListener(handler);
            result.add(item);
        }
        return result;
    }
}
