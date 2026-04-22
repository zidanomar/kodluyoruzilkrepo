import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tabanı giriniz: ");
        int base = scanner.nextInt();
        System.out.print("Üssü giriniz: ");
        int exp = scanner.nextInt();

        // While döngüsü
        long result = 1;
        int i = 0;
        while (i < exp) { result *= base; i++; }
        System.out.println(base + "^" + exp + " = " + result + " (while)");

        // Ödev: For döngüsü
        result = 1;
        for (int j = 0; j < exp; j++) result *= base;
        System.out.println(base + "^" + exp + " = " + result + " (for)");
        scanner.close();
    }
}
