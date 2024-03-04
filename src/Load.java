public class Load implements Instruction{
    private int loc;
    private int value;

    public Load(int loc, int value){
        this.loc = loc;
        this.value = value;
    }

    @Override
    public void execute(MiniMac mac) {
        mac.setMemory(loc,value);
    }

    @Override
    public String toString() {
        return "load " + loc + " " + value;
    }
}
