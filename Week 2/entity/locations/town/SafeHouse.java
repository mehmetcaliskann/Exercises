package com.mehmetcaliskan.entity.locations.town;

import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.locations.Location;

public class SafeHouse extends Location {
    public SafeHouse(Player player) {
        super(player, "Güvenli Bölge");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli bölgedesiniz!");
        if (this.getPlayer().getAwards().size() >= 4) {
            System.out.println("Bütün ödüllere sahipsiniz! Tebrikler!");
            return false;
        }

        System.out.println("Canınız yenilendi!");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
