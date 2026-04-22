import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int n = scanner.nextInt();

        System.out.println("2'nin kuvvetleri:");
        long power = 1;
        while (power <= n) {
            System.out.print(power + " ");
            power *= 2;
        }
        System.out.println();

        System.out.println("\n--- Ödev: 4 ve 5'in kuvvetleri ---");
        System.out.print("4'ün kuvvetleri: ");
        power = 1;
        while (power <= n) { System.out.print(power + " "); power *= 4; }
        System.out.println();

        System.out.print("5'in kuvvetleri: ");
        power = 1;
        while (power <= n) { System.out.print(power + " "); power *= 5; }
        System.out.println();
        scanner.close();
    }
}
