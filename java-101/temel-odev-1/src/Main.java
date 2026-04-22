import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz: ");
        double height = scanner.nextDouble();
        System.out.print("Lütfen kilonuzu giriniz: ");
        double weight = scanner.nextDouble();
        System.out.println("Vücut Kitle İndeksiniz: " + (weight / (height * height)));
        scanner.close();
    }
}
