import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("KDV'siz fiyatı giriniz: ");
        double price = scanner.nextDouble();

        double kdvRate;
        if (price > 0 && price <= 1000) {
            kdvRate = 0.18;
        } else if (price > 1000) {
            kdvRate = 0.08;
        } else {
            System.out.println("Geçersiz fiyat girdiniz!");
            scanner.close();
            return;
        }

        double kdvAmount = price * kdvRate;
        double kdvliPrice = price + kdvAmount;

        System.out.println("KDV Oranı    : %" + (int)(kdvRate * 100));
        System.out.println("KDV Tutarı   : " + kdvAmount);
        System.out.println("KDV'li Fiyat : " + kdvliPrice);
        scanner.close();
    }
}
