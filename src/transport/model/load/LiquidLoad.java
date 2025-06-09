package transport.model.load;

import transport.model.load.Load;

public class LiquidLoad extends Load {
    private String loadType;
    private int volume;

    public LiquidLoad(int weight, int volume) {
        super(weight);
        this.loadType = "transport.model.load.LiquidLoad";
        this.volume = volume;
    }

    public String getLoadType() {
        return loadType;
    }

    public int getVolume() {
        return volume;
    }
}