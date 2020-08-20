package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        playGame(scanner);
    }

    public static void playGame(Scanner scanner) {
        int turn = 0;
        String input = "_________";
        char[][] cells = convertCells(input);

        while ("Game not finished".equals(checkStates(cells))) {
            print(input);
            inputMove(cells, turn, scanner);
            turn = turn == 0 ? 1 : 0;
            input = convertInput(cells);
        }
        
        print(input);
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
                    char output = input.charAt(3 * (i - 1) + (j - 1) / 2);
                    output = output == '_' ? ' ' : output;
                    System.out.print(output);
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
        
        if (completeO >= 1) {
            return "O wins";
        } else if (completeX >= 1) {
            return "X wins";
        }
        
        return totalO + totalX == 9 ? "Draw" : "Game not finished";
    }
    
    public static void inputMove(char[][] cells, int turn, Scanner scanner) {
        String input;
        String[] inputs;
        String first;
        String second;
        
        int x;
        int y;
        
        char temp;
        boolean isInteger;
        
        while (true) {
            System.out.print("Enter the coordinates: ");
            input = scanner.nextLine();

            inputs = input.split(" ");
            if (inputs.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            first = inputs[0];
            second = inputs[1];

            isInteger = true;

            CheckInteger:
            for (int i = 0; i < 2; i++) {
                isInteger = true;
                for (int j = 0; j < inputs[i].length(); j++) {
                    temp = inputs[i].charAt(j);
                    if (temp < '0' || temp > '9') {
                        isInteger = false;
                        break CheckInteger;
                    }
                }
            }
            if (!isInteger) {
                System.out.println("You should enter numbers!");
                continue;
            }
 
            x = 3 - Integer.parseInt(second);
            y = Integer.parseInt(first) - 1;
            
            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (cells[x][y] != '_') {
                System.out.println("This cell is occupied! Choose another one! ");
            } else {
                break;
            }
        }
        
        if (turn == 0) {
            cells[x][y] = 'X';
        } else {
            cells[x][y] = 'O';
        }
    }
    
    public static String convertInput(char[][] cells) {
        String input = "";
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                input += cells[i][j];
            }
        }
        
        return input;
    }
}
