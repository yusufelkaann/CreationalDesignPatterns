package transport.model.load;

public class LiquidFuel extends Load {
    private String type;
    private int volume;
    public LiquidFuel(int weight, int volume) {
        super(weight);
        this.type = "transport.model.load.LiquidFuel";
        this.volume = volume;
    }
    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }
}