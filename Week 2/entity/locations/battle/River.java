package com.mehmetcaliskan.entity.locations.battle;

import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.locations.BattleLocation;
import com.mehmetcaliskan.entity.obstacle.Bear;

public class River extends BattleLocation {
    public River(Player player) {
        super(player, "Nehir", new Bear(), "Water", 2);
    }
}
