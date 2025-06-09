package transport.model.load;

public class DryFood extends Load {
    private String type;
    public DryFood(int weight) {
        super(weight);
        this.type = "transport.model.load.DryFood";
    }
    public String getType() { return type; }
}
