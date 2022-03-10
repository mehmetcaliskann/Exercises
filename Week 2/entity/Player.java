package com.mehmetcaliskan.entity;

import com.mehmetcaliskan.entity.characters.Archer;
import com.mehmetcaliskan.entity.characters.Knight;
import com.mehmetcaliskan.entity.characters.Samurai;
import com.mehmetcaliskan.entity.locations.Location;
import com.mehmetcaliskan.entity.locations.town.SafeHouse;
import com.mehmetcaliskan.entity.locations.town.ToolStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private ArrayList<String> awards;
    private String charName;
    private String name;
    private Inventory inventory;
    private final Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.awards = new ArrayList<>();
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] chars = {samurai, archer, knight};
        System.out.println("-------------------------------------------------");

        for (GameChar gameChar : chars) {
            System.out.println("ID: " + gameChar.getId() + " --> Karakter: " + gameChar.getName() + "\t Hasar: " + gameChar.getDamage() + " \t Sağlık: " + gameChar.getHealth() + " \t Para: " + gameChar.getMoney());
        }
        System.out.println("-------------------------------------------------");
        System.out.print("lütfen bir karakter seçiniz: ");
        int selectedChar = input.nextInt();
        switch (selectedChar) {
            case 1 -> initPlayer(new Samurai());
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Knight());
        }

        // printInfo();
    }

    public void selectLocation() {
        Location location;
        System.out.println("Bölgeler:");
        System.out.println("1 - Güvenli Ev");
        System.out.println("2 - Mağaza");
        System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
        int selectLoc = input.nextInt();
        location = switch (selectLoc) {
            case 1 -> new SafeHouse(this);
            case 2 -> new ToolStore(this);
            default -> new SafeHouse(this);
        };

        location.onLocation();
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println("------------------- Karakter Özeti ---------------------------");
        System.out.println("Karakter: " + this.getCharName() +
                ", Hasar: " + this.getDamage() +
                ", Sağlık: " + this.getHealth() +
                ", Para: " + this.getMoney());
        System.out.println("Silahınız: " + this.getInventory().getWeapon().getName() + " <Hasar: " + this.getInventory().getWeapon().getDamage() + ">");
        System.out.println("Zırhınız: " + this.getInventory().getArmor().getName() + " <Bloklama: " + this.getInventory().getArmor().getBlock() + ">");
        System.out.println("--------------------------------------------------------------");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public ArrayList<String> getAwards() {
        return awards;
    }

    public void setAwards(ArrayList<String> awards) {
        this.awards = awards;
    }
}
