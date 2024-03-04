public class Loop implements Instruction{

    private int count;
    private Instruction body;

    public Loop(int count, Instruction body){
        this.count = count;
        this.body = body;
    }

    @Override
    public void execute(MiniMac mac) {
        for (int i = 0; i < count; i++){
            body.execute(mac);
        }
    }
    @Override
    public String toString() {
        return "loop " + count + " " + body;
    }
}
