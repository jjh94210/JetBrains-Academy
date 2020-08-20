package tictactoe;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.print("Enter cells: ");
        input = scanner.next();

        print(input);
    }
    
    public static void print(String input) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 || i == 4) {
                    System.out.print("-");
                } else if (j == 0 || j == 8) {
                    System.out.print("|");
                } else if (j % 2 == 1) {
                    System.out.print(" ");
                } else {
                    System.out.print(input.charAt(3 * (i - 1) + (j - 1) / 2));
                }
            }
            System.out.println();
        }
    }
}
