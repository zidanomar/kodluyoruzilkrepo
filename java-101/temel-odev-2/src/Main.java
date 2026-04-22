import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Armut Kaç Kilo? : ");
        double armut = scanner.nextDouble();
        System.out.print("Elma Kaç Kilo? : ");
        double elma = scanner.nextDouble();
        System.out.print("Domates Kaç Kilo? : ");
        double domates = scanner.nextDouble();
        System.out.print("Muz Kaç Kilo? : ");
        double muz = scanner.nextDouble();
        System.out.print("Patlıcan Kaç Kilo? : ");
        double patlican = scanner.nextDouble();

        double total = armut * 2.14 + elma * 3.67 + domates * 1.11 + muz * 0.95 + patlican * 5.00;
        System.out.printf("Toplam Tutar: %.2f TL%n", total);
        scanner.close();
    }
}
