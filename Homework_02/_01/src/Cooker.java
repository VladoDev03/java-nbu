class Cooker extends ElectricDevice {
    private boolean isOnGas;

    public Cooker(Manufacturer manufacturer, int minWarranty, boolean isOnGas) {
        super(manufacturer, minWarranty);
        setIsOnGas(isOnGas);
    }

    private void setIsOnGas(boolean isOnGas) {
        this.isOnGas = isOnGas;
    }

    @Override
    public int getWarranty() {
        super.getWarranty();

        if (this.isOnGas) {
            setMinWarranty(getMinWarranty() + 12);
        }

        return getMinWarranty();
    }
}
