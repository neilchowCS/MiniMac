public class Blt implements Instruction{
    private int loc;
    private int offset;

    public Blt(int loc, int offset){
        this.loc = loc;
        this.offset = offset;
    }

    @Override
    public void execute(MiniMac mac) {
        if (mac.getMemory(loc) < 0){
            mac.ip += offset;
        }
    }

    @Override
    public String toString() {
        return "blt " + loc + " " + offset;
    }
}
