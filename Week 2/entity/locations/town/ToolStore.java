package com.mehmetcaliskan.entity.locations.town;

import com.mehmetcaliskan.entity.Armor;
import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.Weapon;
import com.mehmetcaliskan.entity.locations.Location;

public class ToolStore extends Location {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoş geldiniz!");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış yap");
            System.out.print("Seçiminiz: ");
            int selectedCase = input.nextInt();
            while (selectedCase < 1 || selectedCase > 3) {
                System.out.println("Geçersiz değer!");
                selectedCase = input.nextInt();
            }

            switch (selectedCase) {
                case 1 -> printAndBuyWeapon();
                case 2 -> printAndBuyArmor();
                case 3 -> {
                    System.out.println("Bir daha bekleriz.");
                    showMenu = false;
                }
            }
        }

        return true;
    }

    void printAndBuyWeapon() {
        System.out.println("----- Silahlar ------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " --> " + w.getName() + " <Para: " + w.getPrice() + ", Hasar: " + w.getDamage() + ">");
        }
        System.out.println("0 --> (Çıkış Yap)");

        System.out.print("Bir silah seçiniz: ");
        int selectedCase = input.nextInt();
        while (selectedCase < 0 || selectedCase > Weapon.weapons().length) {
            System.out.println("Geçersiz değer!");
            selectedCase = input.nextInt();
        }

        buyWeapon(selectedCase);
    }

    void buyWeapon(int selectedCase) {
        if (selectedCase != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectedCase);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır!");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.print("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("--> Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    void printAndBuyArmor() {
        System.out.println("----- Zırhlar ------");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " --> " + armor.getName() + " <Zırh: " + armor.getBlock() + ", Fiyat: " + armor.getPrice() + ">");
        }

        System.out.print("Bir zırh seçiniz: ");
        int selectedCase = input.nextInt();
        while (selectedCase < 0 || selectedCase > Armor.armors().length) {
            System.out.println("Geçersiz değer!");
            selectedCase = input.nextInt();
        }

        buyArmor(selectedCase);
    }

    void buyArmor(int selectedCase) {
        Armor selectedArmor = Armor.getArmorObjByID(selectedCase);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır!");
            } else {
                System.out.println(selectedArmor.getName() + " zırhını satın aldınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                System.out.print("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("--> Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
            }
        }
    }
}
