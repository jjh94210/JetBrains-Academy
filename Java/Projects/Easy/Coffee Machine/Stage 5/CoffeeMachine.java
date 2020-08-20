package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void printState(int water, int milk, int beans, int cups, int money) {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        
        String command;

        Scanner scanner = new Scanner(System.in);

        machine:
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            
            command = scanner.next();
            
            switch (command) {
                case "buy":
                    System.out.println();
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    
                
                    String coffee = scanner.next();
                    
                    if (coffee == "back") {
                        break;
                    }
                    
                    if (cups < 1) {
                        System.out.println("Sorry, not enough disposable cups!\n");
                        break;
                    }
                    switch (coffee) {
                        case "1":
                            if (water < 250) {
                                System.out.println("Sorry, not enough water!\n");
                                break;
                            } else if (beans < 16) {
                                System.out.println("Sorry, not enough coffee beans!\n");
                                break;
                            }
                            water -= 250;
                            beans -= 16;
                            --cups;
                            money += 4;
                            System.out.println("I have enough resources, making you a coffee!\n");
                            break;
                        case "2":
                            if (water < 350) {
                                System.out.println("Sorry, not enough water!\n");
                                break;
                            } else if (milk < 75) {
                                System.out.println("Sorry, not enough coffee milk!\n");
                                break;
                            } else if (beans < 20) {
                                System.out.println("Sorry, not enough coffee coffee beans!\n");
                                break;
                            }
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            --cups;
                            money += 7;
                            System.out.println("I have enough resources, making you a coffee!\n");
                            break;
                        case "3":
                            if (water < 200) {
                                System.out.println("Sorry, not enough water!\n");
                                break;
                            } else if (milk < 100) {
                                System.out.println("Sorry, not enough coffee milk!\n");
                                break;
                            } else if (beans < 12) {
                                System.out.println("Sorry, not enough coffee coffee beans!\n");
                                break;
                            }
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            --cups;
                            money += 6;
                            System.out.println("I have enough resources, making you a coffee!\n");
                            break;
                        default:
                            break;
                    }
                    break;
                case "fill":
                    System.out.println();
                    System.out.println("Write how many ml of water do you want to add:");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    cups += scanner.nextInt();
                    System.out.println();
                    break;
                case "take":
                    System.out.println();
                    System.out.println("I gave you $" + money + "\n");
                    money = 0;
                    break;
                case "remaining":
                    printState(water, milk, beans, cups, money);
                    continue;
                case "exit":
                    break machine;
            }
        }
    }
}
