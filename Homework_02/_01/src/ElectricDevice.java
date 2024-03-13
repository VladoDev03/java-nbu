class ElectricDevice {
    private Manufacturer manufacturer;
    private int minWarranty;

    public ElectricDevice(Manufacturer manufacturer, int minWarranty) {
        setManufacturer(manufacturer);
        setMinWarranty(minWarranty);
    }

    private void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    protected void setMinWarranty(int minWarranty) {
        if (minWarranty < 6) {
            this.minWarranty = 6;
        } else {
            this.minWarranty = minWarranty;
        }
    }

    public int getMinWarranty() {
        return minWarranty;
    }

    public int getWarranty() {
        if (manufacturer.getHasExtendedWarranty()) {
            setMinWarranty(this.minWarranty + 12);
        }

        return this.minWarranty;
    }
}
