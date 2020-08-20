import java.util.Scanner;

class Next_even_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        int answer = n + (n + 1) % 2 + 1;
        
        System.out.println(answer);
    }
}
