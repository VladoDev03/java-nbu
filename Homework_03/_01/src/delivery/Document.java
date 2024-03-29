package delivery;

public class Document extends DeliverableItem {
    private double minPrice;

    public Document(boolean toAddress, double minPrice) {
        super(toAddress);
        setMinPrice(minPrice);
    }

    public void setMinPrice(double minPrice) {
        if (minPrice <= 0) {
            minPrice = 1;
        }

        this.minPrice = minPrice;
    }

    @Override
    public double deliveryPrice() {
        return super.deliveryPrice() + minPrice;
    }
}
