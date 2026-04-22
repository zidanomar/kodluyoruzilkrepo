import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gidilen mesafeyi (km) giriniz: ");
        double distance = scanner.nextDouble();

        double fare = 10.0 + distance * 2.20;
        if (fare < 20.0) fare = 20.0;

        System.out.println("Taksimetre Tutarı: " + fare + " TL");
        scanner.close();
    }
}
