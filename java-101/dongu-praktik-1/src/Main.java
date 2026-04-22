import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int n = scanner.nextInt();

        System.out.print("Çift sayılar: ");
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n--- Ödev: 3 ve 4'e tam bölünen sayıların ortalaması ---");
        double sum = 0;
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 && i % 4 == 0) { sum += i; count++; }
        }
        System.out.println(count > 0 ? "Ortalama: " + (sum / count) : "Uygun sayı bulunamadı.");
        scanner.close();
    }
}
