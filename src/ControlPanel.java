import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

class ControlPanel extends JPanel implements ActionListener {
    private JFrame frame;
    private MiniMac mac;
    public ControlPanel(MiniMac mac, JFrame frame) {
        this.frame = frame;
        this.mac = mac;
        setBackground(Color.PINK);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 1, 0, 50));
        p.setBackground(Color.PINK);
        JButton parse = new JButton("Parse");
        parse.addActionListener(this);
        p.add(parse);
        add(p);

        JButton run = new JButton("Run");
        run.addActionListener(this);
        p.add(run);
        add(p);

        JButton clear = new JButton("Clear");
        clear.addActionListener(this);
        p.add(clear);
        add(p);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case ("Parse"):
                System.out.println("parse");
                String path = FilePopup.popup();
                if (!Objects.equals(path, "")) {
                    try {
                        String content = new String(Files.readAllBytes(Paths.get(path)));
                        mac.setProgram(MiniMacParser.parse(content));

                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                break;
            case ("Run"):
                System.out.println("run");
                mac.execute();
                break;
            case ("New"):
                System.out.println("new");
                mac.reset();
                break;
            case ("Clear"):
                System.out.println("clear");
                mac.clear();
                break;
            case ("Help"):
                String message = "Parse: Enter name of file path to parse program instructions" +
                        " \nRun: run instructions that have been parsed \nClear: clear memory and program instructions";
                JOptionPane.showMessageDialog(null, message, "Help", JOptionPane.INFORMATION_MESSAGE);
                break;
            case ("Quit"):
                frame.dispose();
                break;
            case ("Save"):
                try {
                    // Writing the object to a file named "serialized_object.ser"
                    FileOutputStream fileOut = new FileOutputStream("serialized_data.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(mac);
                    out.close();
                    fileOut.close();
                    System.out.println("Object has been serialized");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            case ("Open"):
                try {
                    FileInputStream fileIn = new FileInputStream("serialized_data.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    MiniMac m = (MiniMac) in.readObject();
                    mac.clear();
                    mac.setMemory(m.getMemory());
                    mac.setProgram(m.getProgram());
                    in.close();
                    fileIn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }
}