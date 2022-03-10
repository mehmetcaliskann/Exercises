package com.mehmetcaliskan.entity.locations.battle;

import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.locations.BattleLocation;
import com.mehmetcaliskan.entity.obstacle.Vampire;

public class Forest extends BattleLocation {

    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Firewood", 3);
    }
}
