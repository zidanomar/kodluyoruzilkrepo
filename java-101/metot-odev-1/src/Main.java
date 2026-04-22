import java.util.Scanner;

public class Main {
    static void printPowersOf2(int n) {
        System.out.print("2'nin kuvvetleri: ");
        long p = 1;
        while (p <= n) { System.out.print(p + " "); p *= 2; }
        System.out.println();
    }

    static void printPowersOf4And5(int n) {
        System.out.print("4'ün kuvvetleri: ");
        long p = 1;
        while (p <= n) { System.out.print(p + " "); p *= 4; }
        System.out.println();

        System.out.print("5'in kuvvetleri: ");
        p = 1;
        while (p <= n) { System.out.print(p + " "); p *= 5; }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int n = scanner.nextInt();

        printPowersOf2(n);
        System.out.println("--- Ödev ---");
        printPowersOf4And5(n);
        scanner.close();
    }
}
