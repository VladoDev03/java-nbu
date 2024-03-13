class WashingMachine extends ElectricDevice {
    private boolean hasDryingFunction;

    public WashingMachine(Manufacturer manufacturer, int minWarranty, boolean hasDryingFunction) {
        super(manufacturer, minWarranty);
        setHasDryingFunction(hasDryingFunction);
    }

    private void setHasDryingFunction(boolean hasDryingFunction) {
        this.hasDryingFunction = hasDryingFunction;
    }

    @Override
    public int getWarranty() {
        int basicWarranty = getMinWarranty();

        super.getWarranty();

        if (this.hasDryingFunction) {
            setMinWarranty(getMinWarranty() + (int)(basicWarranty * 0.5));
        }

        return getMinWarranty();
    }
}
