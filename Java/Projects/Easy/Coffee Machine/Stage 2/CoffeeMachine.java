package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        final int waterPerCup = 200;
        final int milkPerCup = 50;
        final int coffeeBeansPerCup = 15;
        
        Scanner scanner = new Scanner(System.in);
        
        int cupsOfCoffee;
        int totalWater;
        int totalMilk;
        int totalCoffeeBeans;
        
        System.out.println("Write how many cups of coffee you will need:");
        cupsOfCoffee = scanner.nextInt();
        
        totalWater = waterPerCup * cupsOfCoffee;
        totalMilk = milkPerCup * cupsOfCoffee;
        totalCoffeeBeans = coffeeBeansPerCup * cupsOfCoffee;
        
        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalCoffeeBeans + " g of coffee beans");
    }
}
