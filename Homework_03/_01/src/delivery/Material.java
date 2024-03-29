package delivery;

public class Material {
    private String name;
    private boolean isFragile;

    public Material(String name, boolean isFragile) {
        setName(name);
        setIsFragile(isFragile);
    }

    public boolean getIsFragile() {
        return this.isFragile;
    }

    public void setIsFragile(boolean isFragile) {
        this.isFragile = isFragile;
    }

    public void setName(String name) {
        this.name = name;
    }
}
