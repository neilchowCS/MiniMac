public class Add implements Instruction{
    private int src1;
    private int src2;
    private int dest;

    public Add(int src1, int src2, int dest){
        this.src1 = src1;
        this.src2 = src2;
        this.dest = dest;
    }

    @Override
    public void execute(MiniMac mac) {
        mac.setMemory(dest,mac.getMemory(src1) + mac.getMemory(src2));
    }

    @Override
    public String toString() {
        return "add " + src1 + " " + src2 + " " + dest;
    }
}
