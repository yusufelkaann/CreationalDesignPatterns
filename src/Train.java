public class Train extends Vehicle {
    private String type;

    public Train(String id, int capacity) {
        super(id, capacity);
        this.type = "TIR";
    }

    public String getType() {
        return type;
    }
}