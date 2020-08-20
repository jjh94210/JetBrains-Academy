import java.util.Scanner;

class First_digit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        int first = n / 10;
        
        System.out.println(first);
    }
}
