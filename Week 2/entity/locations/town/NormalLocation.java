package com.mehmetcaliskan.entity.locations.town;

import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.locations.Location;

public class NormalLocation extends Location {
    public NormalLocation(Player player) {
        super(player, "Normal Bölge");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz!");
        return true;
    }
}
