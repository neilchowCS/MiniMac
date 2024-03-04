import java.util.List;

public class Block implements Instruction{
    private List<Instruction> block;

    public Block(List<Instruction> block){
        this.block = block;
    }

    @Override
    public void execute(MiniMac mac) {
        for (Instruction i:block){
            i.execute(mac);
        }
    }

    @Override
    public String toString() {
        String out =  "block {";
        for (Instruction i:block){
            out += " " + i + ";";
        }
        out += " }";
        return out;
    }
}
