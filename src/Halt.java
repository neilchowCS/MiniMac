public class Halt implements Instruction{
    public Halt(){

    }

    @Override
    public void execute(MiniMac mac) {
        mac.halt = true;
    }

    @Override
    public String toString() {
        return "halt";
    }
}
