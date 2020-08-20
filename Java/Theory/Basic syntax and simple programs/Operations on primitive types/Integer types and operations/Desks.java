import java.util.Scanner;

class Desks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int group1 = scanner.nextInt();
        int group2 = scanner.nextInt();
        int group3 = scanner.nextInt();
        
        int desk1 = group1 / 2 + group1 % 2;
        int desk2 = group2 / 2 + group2 % 2;
        int desk3 = group3 / 2 + group3 % 2;
        
        int totalDesk = desk1 + desk2 + desk3;
        
        System.out.println(totalDesk);
    }
}
