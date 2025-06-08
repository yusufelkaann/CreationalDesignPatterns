public class LiquidLoad extends Load {
    private String loadType;
    private int volume;

    public LiquidLoad(int weight, int volume) {
        super(weight);
        this.loadType = "LiquidLoad";
        this.volume = volume;
    }

    public String getLoadType() {
        return loadType;
    }

    public int getVolume() {
        return volume;
    }
}