package delivery;

public class DeliverableItem implements Deliverable {
    private boolean toAddress;
    private static double extraPrice;

    public DeliverableItem(boolean toAddress) {
        setToAddress(toAddress);
    }

    public boolean getToAddress() {
        return toAddress;
    }

    public void setToAddress(boolean toAddress) {
        this.toAddress = toAddress;
    }

    public static double getExtraPrice() {
        return extraPrice;
    }

    public static void setExtraPrice(double extraPrice) {
        if (extraPrice <= 1) {
            extraPrice = 1;
        }

        DeliverableItem.extraPrice = extraPrice;
    }

    @Override
    public double deliveryPrice() {
        double finalPrice = 0;

        if (getToAddress()) {
            finalPrice += DeliverableItem.getExtraPrice();
        }

        return finalPrice;
    }
}
