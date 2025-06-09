package transport.model.load;

public abstract class Load {
    private int weight;
    public Load(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }


}
