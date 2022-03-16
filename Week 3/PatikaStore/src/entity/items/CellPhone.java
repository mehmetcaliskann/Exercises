package entity.items;

import entity.Brand;
import entity.Item;

public class CellPhone extends Item {
    private String storage;
    private String screenSize;
    private String batterySize;
    private String memory;
    private String color;
    private String cameraQuality;

    public CellPhone(int id, int price, int amount, String name, Brand brand, String storage, String screenSize, String batterySize, String memory, String color, String cameraQuality) {
        super(id, price, amount, name, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.batterySize = batterySize;
        this.memory = memory;
        this.color = color;
        this.cameraQuality = cameraQuality;
    }

    public String getCameraQuality() {
        return cameraQuality;
    }

    public void setCameraQuality(String cameraQuality) {
        this.cameraQuality = cameraQuality;
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

    public String getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(String batterySize) {
        this.batterySize = batterySize;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
