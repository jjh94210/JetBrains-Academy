import java.util.Scanner;

class The_sum_of_digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        int answer = n / 100 + (n % 100) / 10 + n % 10;
        
        System.out.println(answer);
    }
}
