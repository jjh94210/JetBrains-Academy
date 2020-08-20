import java.util.Scanner;

class Squirrels_and_nuts_left {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int answer = k % n;
        
        System.out.println(answer);
    }
}
