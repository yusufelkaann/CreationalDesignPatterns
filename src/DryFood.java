public class DryFood extends Load{
    private String type;
    public DryFood(int weight) {
        super(weight);
        this.type = "DryFood";
    }
    public String getType() { return type; }
}
