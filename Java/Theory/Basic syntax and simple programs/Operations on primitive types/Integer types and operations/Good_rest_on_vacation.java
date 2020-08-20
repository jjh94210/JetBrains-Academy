import java.util.Scanner;

class Good_rest_on_vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int duration = scanner.nextInt();
        int foodCost = scanner.nextInt();
        int flightCost = scanner.nextInt();
        int hotelCost = scanner.nextInt();
        
        int totalCost = duration * foodCost + 2 * flightCost + (duration - 1) * hotelCost;
        
        System.out.println(totalCost);
    }
}
