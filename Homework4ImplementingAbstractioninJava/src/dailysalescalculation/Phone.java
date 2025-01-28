public class Phone extends Item {
    private double price;
    private int quantitySold;

    public Phone(double price, int quantitySold) {
        super("Phone");
        this.price = price;
        this.quantitySold = quantitySold;
    }

    @Override
    public double calculateTotalSales() {
        return price * quantitySold;
    }
}