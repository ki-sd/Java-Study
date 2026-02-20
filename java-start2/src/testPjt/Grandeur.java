package testPjt;

import java.util.Scanner;

public class Grandeur {
Scanner scn = new Scanner(System.in);
    public String color;
    public String gear;
    public int price;

    public Grandeur() {
        System.out.println("Grandeur constructor");
    }

    public void run() {
        System.out.println("-- run --");
        System.out.print("색상을 입력해주세요: ");
        color = scn.nextLine();
        System.out.print("기어를 골라주세요(auto, manual): ");
        gear = scn.nextLine();
        System.out.print("가격을 입력해주세요: ");
        price = scn.nextInt();
    }

    public void stop() {
        System.out.println("-- stop --");
    }

    public void info() {
        System.out.println("-- info --");
        System.out.println("color: " + color);
        System.out.println("gear: " + gear);
        System.out.println("price: " + price);
    }

}
