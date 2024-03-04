import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MiniMac extends Publisher implements Serializable {
    public int ip = 0;
    public boolean halt = false;
    private int size = 32;
    private int[] memory = new int[size];

    private ArrayList<Instruction> program = new ArrayList<>();

    public MiniMac(){

    }

    public void setMemory(int loc, int value){
        memory[loc] = value;
        notifySubscribers();
    }

    public void setMemory(int[] newMem){
        memory = newMem;
        notifySubscribers();
    }

    public int getMemory(int loc){
        return memory[loc];
    }

    public int[] getMemory(){
        return memory;
    }

    public void setProgram(ArrayList<Instruction> program) {
        this.program = program;
        notifySubscribers();
    }

    public ArrayList<Instruction> getProgram() {
        return program;
    }

    public void execute(){
        ip = 0;
        halt = false;
        while (!halt && ip < program.size()){
            program.get(ip).execute(this);
            ip++;
        }
    }

    public void clear(){
        memory = new int[size];

        notifySubscribers();
    }

    public void reset(){
        program = new ArrayList<>();
        memory = new int[size];

        notifySubscribers();
    }
}
