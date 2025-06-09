package transport.model.load;

public class DryLoad extends Load {
    private String type;
    public DryLoad(int weight) {
        super(weight);
        this.type = "transport.model.load.DryLoad";
    }
    public String getType() { return type;}
}
