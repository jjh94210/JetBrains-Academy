import java.util.Scanner;

class Arithmetic_expression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        int answer = ((n + 1) * n + 2) * n + 3;
        
        System.out.println(answer);
    }
}
