import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MiniMacView extends JPanel implements Subscriber {
    private MiniMac miniMac;
    private DefaultListModel<String> memoryListModel;
    private DefaultListModel<String> programListModel;

    public MiniMacView(MiniMac miniMac){
        this.miniMac = miniMac;
        miniMac.subscribe(this);
        this.setLayout(new GridLayout(2,1));

        memoryListModel = new DefaultListModel<>();
        programListModel = new DefaultListModel<>();

        this.add(new JScrollPane(new JList<String>(memoryListModel)));
        this.add(new JScrollPane(new JList<String>(programListModel)));

        updateMemoryList(miniMac.getMemory());
        updateProgramList(miniMac.getProgram());
    }

    private void updateMemoryList(int[] mem) {
        memoryListModel.clear();
        for (int i = 0; i < mem.length; i++) {
            memoryListModel.addElement("memory[" + i + "] = " + mem[i]); // Add new content
        }
    }

    private void updateProgramList(ArrayList<Instruction> instructions) {
        programListModel.clear(); // Clear the existing content
        for (Instruction instruction : instructions) {
            programListModel.addElement(instruction.toString()); // Add new content
        }
    }
    @Override
    public void update() {
        updateMemoryList(miniMac.getMemory());
        updateProgramList(miniMac.getProgram());
        repaint();
    }
}
