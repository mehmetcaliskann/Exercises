package com.mehmetcaliskan.entity.locations.battle;

import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.locations.BattleLocation;
import com.mehmetcaliskan.entity.obstacle.Zombie;

public class Cave extends BattleLocation {
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "Food", 3);
    }
}
