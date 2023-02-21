public class Drinks extends Product{

    private double volume;

    public Drinks(String name, double cost, double volume){
        super(name, cost);
        this.volume = volume;
    }

    @Override
    public String toString() {
        StringBuilder localString = new StringBuilder(super.toString());
        localString.append(String.format(" объём напитка %s", volume));
        return localString.toString();
    }
}
