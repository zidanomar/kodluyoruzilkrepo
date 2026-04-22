import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Negatif sayı girene kadar sayı giriniz:");
        int sumOdd = 0, num;
        while ((num = scanner.nextInt()) >= 0) {
            if (num % 2 != 0) sumOdd += num;
        }
        System.out.println("Tek sayıların toplamı: " + sumOdd);

        System.out.println("\n--- Ödev: Tek sayı girene kadar çift ve 4'ün katı sayıların toplamı ---");
        int sumEvenDiv4 = 0;
        while (true) {
            num = scanner.nextInt();
            if (num % 2 != 0) break;
            if (num % 4 == 0) sumEvenDiv4 += num;
        }
        System.out.println("Çift ve 4'ün katlarının toplamı: " + sumEvenDiv4);
        scanner.close();
    }
}
