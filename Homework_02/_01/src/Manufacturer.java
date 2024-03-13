class Manufacturer {
    private String name;
    private boolean hasExtendedWarranty;

    public Manufacturer(String name, boolean hasExtendedWarranty) {
        setName(name);
        setHasExtendedWarranty(hasExtendedWarranty);
    }

    public boolean getHasExtendedWarranty() {
        return hasExtendedWarranty;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setHasExtendedWarranty(boolean hasExtendedWarranty) {
        this.hasExtendedWarranty = hasExtendedWarranty;
    }
}
