import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double PI = 3.14;

        System.out.print("Yarıçapı giriniz: ");
        double r = scanner.nextDouble();

        System.out.println("Alan   : " + (PI * r * r));
        System.out.println("Çevre  : " + (2 * PI * r));

        System.out.println("\n--- Ödev: Daire Dilimi Alanı ---");
        System.out.print("Merkez açısını (α) giriniz: ");
        double alpha = scanner.nextDouble();
        System.out.println("Daire Dilimi Alanı: " + ((PI * r * r * alpha) / 360));
        scanner.close();
    }
}
