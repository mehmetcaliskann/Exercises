package entity;

import entity.items.CellPhone;
import entity.items.Laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    private final List<CellPhone> cellPhones;
    private final List<Laptop> laptops;

    public Inventory() {
        this.cellPhones = new ArrayList<>();
        this.laptops = new ArrayList<>();
    }

    public void initialize() {
        initCellPhones();
        initLaptops();
    }

    private void initCellPhones() {
        CellPhone cellPhone1 = new CellPhone(1, 3199, 15, "SAMSUNG Galaxy A51", BrandManager.getBrandByName("Samsung"), "128", "6.5", "4000", "6", "Siyah", "32");
        CellPhone cellPhone2 = new CellPhone(2, 7379, 5, "iPhone 12 Pro Max", BrandManager.getBrandByName("Apple"), "128", "6.1", "3800", "6", "Mavi", "12");
        CellPhone cellPhone3 = new CellPhone(3, 4012, 25, "Redmi Note 10 Pro 8GB", BrandManager.getBrandByName("Xiaomi"), "128", "6.5", "4000", "8", "Beyaz", "64");

        cellPhones.addAll(Arrays.asList(cellPhone1, cellPhone2, cellPhone3));
    }

    private void initLaptops() {
        Laptop laptop1 = new Laptop(1, 7000, 10, "HUAWEI Matebook 14", BrandManager.getBrandByName("Huawei"), "16", "512", "14.0");
        Laptop laptop2 = new Laptop(2, 3699, 20, "LENOVO V14 IGL", BrandManager.getBrandByName("Lenovo"), "8", "1024", "14.0");
        Laptop laptop3 = new Laptop(3, 8199, 5, "ASUS TUF Gaming", BrandManager.getBrandByName("Asus"), "32", "2048", "15.6");

        laptops.addAll(Arrays.asList(laptop1, laptop2, laptop3));
    }

    public List<CellPhone> getCellPhones() {
        return cellPhones;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public boolean addCellPhone(CellPhone cellPhone) {
        if (cellPhones.stream().anyMatch(cellPhone1 -> cellPhone1.getId() == cellPhone.getId())) {
            System.out.println("Aynı ID'ye sahip cep telefonu bulunduğu için işlem gerçekleştirilemedi!");
            return false;
        }

        return cellPhones.add(cellPhone);
    }

    public boolean deleteCellPhoneById(int id) {
        return cellPhones.removeIf(cellPhone -> cellPhone.getId() == id);
    }

    public boolean deleteLaptopById(int id) {
        return laptops.removeIf(laptop -> laptop.getId() == id);
    }
}
