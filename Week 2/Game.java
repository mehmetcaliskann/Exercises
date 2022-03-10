package com.mehmetcaliskan;

import com.mehmetcaliskan.entity.Player;
import com.mehmetcaliskan.entity.locations.Location;
import com.mehmetcaliskan.entity.locations.battle.Cave;
import com.mehmetcaliskan.entity.locations.battle.Forest;
import com.mehmetcaliskan.entity.locations.battle.Mines;
import com.mehmetcaliskan.entity.locations.battle.River;
import com.mehmetcaliskan.entity.locations.town.SafeHouse;
import com.mehmetcaliskan.entity.locations.town.ToolStore;

import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hosgeldiniz!");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + ", bu karanlık ve sisli adaya hoşgeldiniz! Burada yaşananların hepsi gerçek!");
        System.out.println("Lütfen bir karakter seçiniz: ");
        player.selectChar();

        Location location;
        while (true) {
            player.printInfo();
            System.out.println("############## Bölgeler #############");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.println("3 - Mağara");
            System.out.println("4 - Orman");
            System.out.println("5 - Nehir");
            System.out.println("6 - Maden");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            location = switch (selectLoc) {
                case 0 -> null;
                case 1 -> new SafeHouse(player);
                case 2 -> new ToolStore(player);
                case 3 -> new Cave(player);
                case 4 -> new Forest(player);
                case 5 -> new River(player);
                case 6 -> new Mines(player);
                default -> new SafeHouse(player);
            };

            if (location == null) {
                System.out.println("Bu adadan vazgeçtin!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
