import java.util.Scanner;

class Difference_of_times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int beforeHour = scanner.nextInt();
        int beforeMinute = scanner.nextInt();
        int beforeSecond = scanner.nextInt();

        int afterHour = scanner.nextInt();
        int afterMinute = scanner.nextInt();
        int afterSecond = scanner.nextInt();
        
        int diff = ((afterHour - beforeHour) * 60 + (afterMinute - beforeMinute)) * 60 + afterSecond - beforeSecond;
        
        System.out.println(diff);        
    }
}
