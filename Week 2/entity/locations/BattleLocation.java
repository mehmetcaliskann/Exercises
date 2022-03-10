package com.mehmetcaliskan.entity.locations;

import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.obstacle.Obstacle;

import java.util.ArrayList;
import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private Integer maxObstacle;
    private final Random random = new Random();

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, Integer maxObstacle) {
        super(player, name);
        this.award = award;
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        if (this.getPlayer().getAwards().contains(this.award)) {
            System.out.println("Buradaki ödüle zaten sahipsiniz!");
            return true;
        }

        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor!");
        System.out.print("<S>avaş veya <K>aç: ");
        String selectedCase = input.nextLine();
        selectedCase = selectedCase.toUpperCase();
        if (selectedCase.equals("S")) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz!");

                System.out.println("Bölgeye özel ödülünüz: " + this.getAward());
                ArrayList<String> awards = this.getPlayer().getAwards();
                awards.add(this.award);
                this.getPlayer().setAwards(awards);

                return true;
            }
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<V>ur veya <K>aç: ");
                String selectedCase = input.nextLine().toUpperCase();
                if (selectedCase.equals("V")) {
                    if (random.nextBoolean()) {
                        System.out.println("Siz vurdunuz!");
                        this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu!");
                            int damage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - (Math.max(damage, 0)));
                            afterHit();
                        }
                    } else {
                        System.out.println("Canavar size vurdu!");
                        int damage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - (Math.max(damage, 0)));
                        afterHit();

                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Siz vurdunuz!");
                            this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }

                } else {
                    return false;
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı yendiniz!");
                addAward();
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " canı: " + this.getObstacle().getHealth());
    }

    public void addAward() {
        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
        System.out.println(this.getObstacle().getAward() + " para kazandınız!");
        System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
    }

    public void playerStats() {
        System.out.println("Oyuncu değerleri");
        System.out.println("--------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("---------------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + (this.getObstacle().getAward() != null ? this.getObstacle().getAward() : "Rastgele"));
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(maxObstacle) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
