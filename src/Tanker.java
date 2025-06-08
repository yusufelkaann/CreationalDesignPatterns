public class Tanker extends Vehicle {
    private String type;

    public Tanker(String id, int capacity) {
        super(id, capacity);
        this.type = "TIR";
    }

    public String getType() {
        return type;
    }
}