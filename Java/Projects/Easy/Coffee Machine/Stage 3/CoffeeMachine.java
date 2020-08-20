package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfNeed = scanner.nextInt();
        
        int cupsOfCoffee = water / 200;
        if (cupsOfCoffee > milk / 50) {
            cupsOfCoffee = milk / 50;
        }
        if (cupsOfCoffee > beans / 15) {
            cupsOfCoffee = beans / 15;
        }
        
        if (cupsOfNeed < cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (cupsOfCoffee - cupsOfNeed) + " more than that)");
        } else if (cupsOfNeed == cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("No, I can make only " + cupsOfCoffee + " cup(s) of coffee");
        }
    }
}
