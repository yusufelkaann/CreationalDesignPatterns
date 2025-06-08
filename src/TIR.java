public class TIR extends Vehicle {
    private String type;

    public TIR(String id, int capacity) {
        super(id, capacity);
        this.type = "TIR";
    }

    public String getType() {
        return type;
    }
}
