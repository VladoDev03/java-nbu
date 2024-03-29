package delivery;

public class WeightedItem extends DeliverableItem {
    private Material material;
    private double weight;
    private double pricePerKg;

    public WeightedItem(boolean toAddress, Material material, double weight, double pricePerKg) {
        super(toAddress);
        this.material = material;
        setWeight(weight);
        setPricePerKg(pricePerKg);
    }

    public WeightedItem(boolean toAddress) {
        super(toAddress);
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            weight = 1;
        }

        this.weight = weight;
    }

    public void setPricePerKg(double pricePerKg) {
        if (pricePerKg <= 0) {
            pricePerKg = 1;
        }

        this.pricePerKg = pricePerKg;
    }

    @Override
    public double deliveryPrice() {
        double finalPrice = (pricePerKg * weight) + super.deliveryPrice();

        if (material.getIsFragile()) {
            finalPrice = finalPrice + (finalPrice * ((double) 1 / 100));
        }

        return finalPrice;
    }
}
