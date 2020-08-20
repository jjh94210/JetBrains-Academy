import java.util.Scanner;

class Reversing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        int first = n / 100;
        int second = (n % 100) / 10;
        int third = n % 10;
        
        int reverse = (third * 10 + second) * 10 + first;
        
        System.out.println(reverse);
    }
}
