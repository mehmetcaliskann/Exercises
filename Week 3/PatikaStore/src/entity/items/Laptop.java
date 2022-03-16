package entity.items;

import entity.Brand;
import entity.Item;

public class Laptop extends Item {
    private String memory;
    private String storage;
    private String screenSize;

    public Laptop(int id, int price, int amount, String name, Brand brand, String memory, String storage, String screenSize) {
        super(id, price, amount, name, brand);
        this.memory = memory;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}
