public class Repair extends Item {
    private double pricePerHour;
    private int numberOfHours;

    public Repair(double pricePerHour, int numberOfHours) {
        super("Repair");
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }

    @Override
    public double calculateTotalSales() {
        return pricePerHour * numberOfHours;
    }
}