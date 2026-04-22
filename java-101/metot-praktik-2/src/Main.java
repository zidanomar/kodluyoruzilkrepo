import java.util.Scanner;

public class Main {
    static int sumOddUntilNegative(Scanner scanner) {
        System.out.println("Negatif girene kadar sayı giriniz:");
        int sum = 0, num;
        while ((num = scanner.nextInt()) >= 0) {
            if (num % 2 != 0) sum += num;
        }
        return sum;
    }

    static int sumEvenDiv4UntilOdd(Scanner scanner) {
        System.out.println("Tek sayı girene kadar sayı giriniz:");
        int sum = 0, num;
        while (true) {
            num = scanner.nextInt();
            if (num % 2 != 0) break;
            if (num % 4 == 0) sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tek sayıların toplamı: " + sumOddUntilNegative(scanner));
        System.out.println("\n--- Ödev ---");
        System.out.println("Çift ve 4'ün katlarının toplamı: " + sumEvenDiv4UntilOdd(scanner));
        scanner.close();
    }
}
