package entity;

import java.util.TreeSet;

public class BrandManager {
    static final TreeSet<Brand> brands = new TreeSet<>();

    static {
        brands.add(new Brand("Samsung"));
        brands.add(new Brand("Lenovo"));
        brands.add(new Brand("Apple"));
        brands.add(new Brand("Huawei"));
        brands.add(new Brand("Casper"));
        brands.add(new Brand("Asus"));
        brands.add(new Brand("HP"));
        brands.add(new Brand("Xiaomi"));
        brands.add(new Brand("Monster"));
    }

    public static Brand getBrandByName(String name) {
        return brands.stream().filter(brand -> brand.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public void printBrands() {
        brands.forEach(brand -> System.out.println("- " + brand.getName()));
    }

}
