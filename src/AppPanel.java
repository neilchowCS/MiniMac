import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel extends JPanel{
    private ControlPanel controls;
    private MiniMacView view;

    public AppPanel() {
        JFrame frame = new JFrame();

        MiniMac mac = new MiniMac();
        view = new MiniMacView(mac);
        controls = new ControlPanel(mac, frame);
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(new MenuPanel(controls));
        frame.setTitle("MiniMac");
        frame.setSize(500, 300);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        AppPanel app = new AppPanel();

    }
}