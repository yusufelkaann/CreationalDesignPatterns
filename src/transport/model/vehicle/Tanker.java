package transport.model.vehicle;

public class Tanker extends Vehicle {
    private String type;

    public Tanker(String id, int capacity) {
        super(id, capacity);
        this.type = "transport.model.vehicle.TIR";
    }

    public String getType() {
        return type;
    }
}