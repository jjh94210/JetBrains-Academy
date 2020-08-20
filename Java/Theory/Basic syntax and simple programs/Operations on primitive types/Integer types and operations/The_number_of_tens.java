import java.util.Scanner;

class The_number_of_tens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        int answer = ((n % 100) / 10) % 10;
        
        System.out.println(answer);
    }
}
