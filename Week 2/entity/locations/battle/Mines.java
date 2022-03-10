package com.mehmetcaliskan.entity.locations.battle;

import com.mehmetcaliskan.entity.Armor;
import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.Weapon;
import com.mehmetcaliskan.entity.locations.BattleLocation;
import com.mehmetcaliskan.entity.obstacle.Snake;

import java.util.Random;

public class Mines extends BattleLocation {
    public Mines(Player player) {
        super(player, "Maden", new Snake(), "Treasure", null);
    }

    @Override
    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(6 - 3) + 3;
    }

    @Override
    public void addAward() {
        Random r = new Random();
        int number = r.nextInt(100);

        if (number < 15) {
            // Random weapon
            int weaponNumber = r.nextInt(100);
            Weapon award;

            if (weaponNumber < 20) {
                award = Weapon.getWeaponObjByID(3);
            } else if (weaponNumber < 50) {
                award = Weapon.getWeaponObjByID(2);
            } else {
                award = Weapon.getWeaponObjByID(1);
            }

            if (this.getPlayer().getInventory().getWeapon().getDamage() < award.getDamage()) {
                this.getPlayer().getInventory().setWeapon(award);
                System.out.println("Ganimetten " + award.getName() + " silahı çıktı! Tebrikler.");
            } else {
                System.out.println("Mevcut silahınız ganimetteki " + award.getName() + " silahından daha iyi olduğu için ganimet atlanıldı.");
            }
        } else if (number < 30) {
            // Random armor
            int armorNumber = r.nextInt(100);
            Armor award;

            if (armorNumber < 20) {
                award = Armor.getArmorObjByID(3);
            } else if (armorNumber < 50) {
                award = Armor.getArmorObjByID(2);
            } else {
                award = Armor.getArmorObjByID(1);
            }

            if (this.getPlayer().getInventory().getArmor().getBlock() < award.getBlock()) {
                this.getPlayer().getInventory().setArmor(award);
                System.out.println("Ganimetten " + award.getName() + " zırh çıktı! Tebrikler.");
            } else {
                System.out.println("Mevcut zırhınız ganimetteki " + award.getName() + " zırhtan daha iyi olduğu için ganimet atlanıldı.");
            }
        } else if (number < 55) {
            // Random money
            int moneyNumber = r.nextInt(100);
            int award;

            if (moneyNumber < 20) {
                award = 10;
            } else if (moneyNumber < 50) {
                award = 5;
            } else {
                award = 1;
            }

            this.getPlayer().setMoney(this.getPlayer().getMoney() + award);
        } else {
            System.out.println("Hiçbir şey kazanamadınız :(");
        }
    }
}
