package com.mehmetcaliskan.entity.obstacle;

import java.util.Random;

public class Snake extends Obstacle {
    public Snake() {
        super(4, "Yılan", -1, 12, null);
        Random random = new Random();
        int damage = random.nextInt(6 - 3) + 3;
        this.setDamage(damage);
    }
}
