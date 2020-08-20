package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final Scanner scanner;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachine() {
        scanner = new Scanner(System.in);
        water = 400;
        milk = 540;
        beans = 120;
        cups = 9;
        money = 550;
    }

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        scanner = new Scanner(System.in);
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();

        boolean isMachineOn = true;

        while (isMachineOn) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            
            switch (machine.getAction()) {
                case "buy":
                    machine.buyCoffee();
                    break;
                case "fill":
                    machine.fill();
                    break;
                case "take":
                    machine.take();
                    break;
                case "remaining":
                    machine.printState();
                    break;
                case "exit":
                    isMachineOn = false;
                    break;
                default:
                    break;
            }
        }
    }

    public String getAction() {
        return scanner.next();
    }

    public void buyCoffee() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String order = scanner.next();

        if (!"back".equals(order)) {
            buy(Integer.parseInt(order));
        }
    }

    public void buy(int coffeeMenu) {
        switch (coffeeMenu) {
            case 1:
                if (checkSupplies(CoffeeMenu.ESPRESSO.water(), CoffeeMenu.ESPRESSO.milk(), CoffeeMenu.ESPRESSO.beans())) {
                    water -= CoffeeMenu.ESPRESSO.water();
                    beans -= CoffeeMenu.ESPRESSO.beans();
                    money += CoffeeMenu.ESPRESSO.money();
                    --cups;
                }
                break;
            case 2:
                if (checkSupplies(CoffeeMenu.LATTE.water(), CoffeeMenu.LATTE.milk(), CoffeeMenu.LATTE.beans())) {
                    water -= CoffeeMenu.LATTE.water();
                    milk -= CoffeeMenu.LATTE.milk();
                    beans -= CoffeeMenu.LATTE.beans();
                    money += CoffeeMenu.LATTE.money();
                    --cups;
                }
                break;
            case 3:
                if (checkSupplies(CoffeeMenu.CAPPUCCINO.water(), CoffeeMenu.CAPPUCCINO.milk(), CoffeeMenu.CAPPUCCINO.beans())) {
                    water -= CoffeeMenu.CAPPUCCINO.water();
                    milk -= CoffeeMenu.CAPPUCCINO.milk();
                    beans -= CoffeeMenu.CAPPUCCINO.beans();
                    money += CoffeeMenu.CAPPUCCINO.money();
                    --cups;
                }
                break;
            default:
                break;
        }
    }

    private boolean checkSupplies(int water, int milk, int beans) {
        if (this.water < water) {
            System.out.println("Sorry, not enough water!\n");
            return false;
        } else if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!\n");
            return false;
        } else if (this.beans < beans) {
            System.out.println("Sorry, not enough coffee beans!\n");
            return false;
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups!\n");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            return true;
        }
    }

    public void fill() {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.cups += scanner.nextInt();
        System.out.println();
    }

    public void take() {
        System.out.println();
        System.out.println("I gave you $" + money + "\n");
        money = 0;
    }

    public void printState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money\n");
    }

}

/**
 * Implements of CoffeeMenu enum class for CoffeeMachine
 *
 * @author Jaehwi Cho
 */
enum CoffeeMenu {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int beans;
    private final int money;

    CoffeeMenu(int water, int milk, int beans, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
    }

    public int water() {
        return water;
    }

    public int milk() {
        return milk;
    }

    public int beans() {
        return beans;
    }

    public int money() {
        return money;
    }
}
