import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinci dik kenarı giriniz: ");
        double a = scanner.nextDouble();
        System.out.print("İkinci dik kenarı giriniz: ");
        double b = scanner.nextDouble();

        double hypotenuse = Math.sqrt(a * a + b * b);
        System.out.println("Hipotenüs: " + hypotenuse);

        System.out.println("\n--- Ödev: Üçgen Alanı (Heron Formülü) ---");
        System.out.print("a kenarı: ");
        double ta = scanner.nextDouble();
        System.out.print("b kenarı: ");
        double tb = scanner.nextDouble();
        System.out.print("c kenarı: ");
        double tc = scanner.nextDouble();

        double u = (ta + tb + tc) / 2;
        double area = Math.sqrt(u * (u - ta) * (u - tb) * (u - tc));
        System.out.println("Üçgenin Alanı: " + area);
        scanner.close();
    }
}
