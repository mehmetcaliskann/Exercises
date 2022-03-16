package entity;

public class Brand implements Comparable<Brand> {
    private static int brandCount = 0;
    private int id;
    private String name;

    public Brand(String name) {
        this.id = brandCount++;
        this.name = name;
    }

    public static int getBrandCount() {
        return brandCount;
    }

    public static void setBrandCount(int brandCount) {
        Brand.brandCount = brandCount;
    }

    @Override
    public int compareTo(Brand o) {
        return name.compareTo(o.getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
