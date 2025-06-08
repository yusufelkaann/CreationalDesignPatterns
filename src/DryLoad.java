public class DryLoad extends Load{
    private String type;
    public DryLoad(int weight) {
        super(weight);
        this.type = "DryLoad";
    }
    public String getType() { return type;}
}
