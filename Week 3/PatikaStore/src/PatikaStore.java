import entity.Brand;
import entity.BrandManager;
import entity.Inventory;
import entity.items.CellPhone;

import java.util.Scanner;

public class PatikaStore {
    private final Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private BrandManager brandManager;

    public PatikaStore() {
        inventory = new Inventory();
        brandManager = new BrandManager();
    }

    void run() {
        inventory.initialize();

        while (true) {
            int userChoice = printConsoleAndGetChoice();

            switch (userChoice) {
                case 0:
                    return;
                case 1:
                    printLaptops();
                    break;
                case 2:
                    printCellPhones();
                    break;
                case 3:
                    brandManager.printBrands();
                    break;
            }
        }
    }

    private int printConsoleAndGetChoice() {
        int choice;
        do {
            System.out.println("PatikaStore Ürün Yönetim Paneli");
            System.out.println("1 - Laptop İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            choice = input.nextInt();
        } while (choice < 0 || choice > 3);

        return choice;
    }

    private void printCellPhones() {
        final String lineFormat = "| %-4s | %-32s | %-12s  | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s |  %-12s |%n";
        int userChoice;

        while (true) {
            System.out.println("Cep Telefonları");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.format(lineFormat, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            inventory.getCellPhones().forEach(cellPhone -> System.out.format(lineFormat, cellPhone.getId(), cellPhone.getName(), cellPhone.getPrice(), cellPhone.getBrand().getName(), cellPhone.getStorage(), cellPhone.getScreenSize(), cellPhone.getCameraQuality(), cellPhone.getBatterySize(), cellPhone.getMemory(), cellPhone.getColor()));
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("İşlemler");
            System.out.println("1 - Ekle");
            System.out.println("2 - Sil");
            System.out.println("0 - Geri Dön");
            System.out.print("Seçiminiz: ");
            userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    int id, price, amount;
                    String name, storage, screenSize, batterySize, memory, color, cameraQuality;
                    Brand brand;

                    System.out.println("Eklemek istediğiniz ürün bilgilerini giriniz");
                    System.out.print("ID: ");
                    id = input.nextInt();
                    System.out.print("Fiyat: ");
                    price = input.nextInt();
                    System.out.print("Adet: ");
                    amount = input.nextInt();
                    input.nextLine();
                    System.out.print("Ürün adı: ");
                    name = input.nextLine();
                    System.out.print("Marka adı: ");
                    brand = BrandManager.getBrandByName(input.nextLine());
                    System.out.print("Depolama: ");
                    storage = input.nextLine();
                    System.out.print("Ekran boyutu: ");
                    screenSize = input.nextLine();
                    System.out.print("Batarya: ");
                    batterySize = input.nextLine();
                    System.out.print("RAM: ");
                    memory = input.nextLine();
                    System.out.print("Renk: ");
                    color = input.nextLine();
                    System.out.print("Kamera Kalitesi: ");
                    cameraQuality = input.nextLine();

                    if (brand != null) {
                        if (inventory.addCellPhone(new CellPhone(id, price, amount, name, brand, storage, screenSize, batterySize, memory, color, cameraQuality))) {
                            System.out.println("Ürün başarıyla eklendi!");
                        } else {
                            System.out.println("Ürün eklenirken bir hata oluştu!");
                        }
                    } else {
                        System.out.println("Geçerli bir marka ismi giriniz!");
                    }
                    break;
                case 2:
                    System.out.print("Silmek istediğiniz ürünün ID'sini giriniz: ");
                    boolean result = inventory.deleteCellPhoneById(input.nextInt());
                    if (result) {
                        System.out.println("Ürün başarıyla silindi!");
                    } else {
                        System.out.println("Ürün silinemedi");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    private void printLaptops() {
        final String lineFormat = "| %-4s | %-32s | %-12s  | %-12s | %-12s | %-12s | %-6s |%n";
        System.out.println("Laptoplar");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.format(lineFormat, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        inventory.getLaptops().forEach(laptop -> System.out.format(lineFormat, laptop.getId(), laptop.getName(), laptop.getPrice(), laptop.getBrand().getName(), laptop.getStorage(), laptop.getScreenSize(), laptop.getMemory()));
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
