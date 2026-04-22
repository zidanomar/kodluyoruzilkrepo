import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mesafeyi km türünden giriniz: ");
        double distance = scanner.nextDouble();
        System.out.print("Yaşınızı giriniz: ");
        int age = scanner.nextInt();
        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş Dönüş): ");
        int tripType = scanner.nextInt();

        if (distance <= 0 || age <= 0 || (tripType != 1 && tripType != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
            scanner.close();
            return;
        }

        double total = distance * 0.10;

        double ageDiscount = 0;
        if (age < 12)       ageDiscount = 0.50;
        else if (age <= 24) ageDiscount = 0.10;
        else if (age > 65)  ageDiscount = 0.30;

        total = total - total * ageDiscount;

        if (tripType == 2) {
            total = total - total * 0.20;
            total = total * 2;
        }

        System.out.println("Toplam Tutar = " + total + " TL");
        scanner.close();
    }
}
