import java.util.Scanner;

class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        System.out.println((h - b) / (a - b) + ((h - b) % (a - b) + (a - b) - 1) / (a - b));
    }
}
