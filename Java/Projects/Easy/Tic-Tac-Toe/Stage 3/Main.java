package tictactoe;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.print("Enter cells: ");
        input = scanner.next();

        print(input);

        char[][] cells = convertCells(input);

        System.out.println(checkStates(cells));
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
    
    public static char[][] convertCells(String input) {
        char[][] cells = new char[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = input.charAt(3 * i + j);
            }
        }
        
        return cells;
    }
    
    public static String checkStates(char[][] cells) {
        int totalO = 0;
        int totalX = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == 'O') {
                    ++totalO;  
                } else if (cells[i][j] == 'X') {
                    ++totalX;
                }
            }
        }
        
        if (Math.abs(totalO - totalX) > 1) {
            return "Impossible";
        }
        
        int completeO = 0;
        int completeX = 0;
        
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                if (cells[i][0] == 'O') {
                    ++completeO;
                } else if (cells[i][0] == 'X') {
                    ++completeX;
                }
            }
            
            if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                if (cells[0][i] == 'O') {
                    ++completeO;
                } else if (cells[0][i] == 'X') {
                    ++completeX;
                }
            }
        }
        
        if (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            if (cells[0][0] == 'O') {
                ++completeO;
            } else if (cells[0][0] == 'X') {
                ++completeX;
            }
        }
        if (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            if (cells[0][2] == 'O') {
                ++completeO;
            } else if (cells[0][2] == 'X') {
                ++completeX;
            }
        }
        
        if (completeO + completeX > 1) {
            return "Impossible";
        }
        
        if (completeO == 1) {
            return "O wins";
        } else if (completeX == 1) {
            return "X wins";
        }
        
        return totalO + totalX == 9 ? "Draw" : "Game not finished";
    }
}
