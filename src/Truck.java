public class Truck extends Vehicle{
    private String type;

    public Truck(String id, int capacity) {
        super(id, capacity);
        this.type = "Truck";
    }

    public String getType() {
        return type;
    }
}
