package controller;

import views.GamePanel;
import javax.swing.*;

public class Main {

        public static void main(String[] args) {

            JFrame window = new JFrame("T-JAV-501");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setIgnoreRepaint(true);

            GamePanel gamePanel = new GamePanel();
            window.add(gamePanel);
            window.pack();
            gamePanel.startGameLoop();

            window.setLocationRelativeTo(null);
            window.setVisible(true);

//                System.out.println("--------------------");
//                System.out.println("Setup des combattants");
//                System.out.println("--------------------");
//
//                Fighter nathan = new Warrior("Nathan", Type.PLANT);
//                Fighter victor = new Warrior("Victor", Type.FIRE);
//                Weapon firesword = new FireSword();
//                Weapon icesword = new IceSword();
//                Item healPotion = new HealPotion();
//                Item damageBooster = new DamageBooster();
//
//                nathan.pickWeapon(firesword);
//                victor.pickWeapon(icesword);
//
//                nathan.pickItems(Arrays.asList(healPotion, damageBooster));
//
//                System.out.println("--------------------");
//                System.out.println("Début du combat");
//                System.out.println("--------------------");
//
//                Arena arena = new Arena(nathan, victor);


        }


}