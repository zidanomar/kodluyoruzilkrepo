import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kaç tane sayı gireceksiniz: ");
        int n = scanner.nextInt();

        System.out.print("1. Sayıyı giriniz: ");
        int num = scanner.nextInt();
        int max = num, min = num;

        for (int i = 2; i <= n; i++) {
            System.out.print(i + ". Sayıyı giriniz: ");
            num = scanner.nextInt();
            if (num > max) max = num;
            if (num < min) min = num;
        }

        System.out.println("En büyük sayı: " + max);
        System.out.println("En küçük sayı: " + min);
        scanner.close();
    }
}
