import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Birinci sayıyı giriniz: ");
        int a = scanner.nextInt();
        System.out.print("İkinci sayıyı giriniz: ");
        int b = scanner.nextInt();
        System.out.print("Üçüncü sayıyı giriniz: ");
        int c = scanner.nextInt();

        int temp;
        if (a > b) { temp = a; a = b; b = temp; }
        if (a > c) { temp = a; a = c; c = temp; }
        if (b > c) { temp = b; b = c; c = temp; }

        System.out.println("Küçükten büyüğe: " + a + " " + b + " " + c);
        scanner.close();
    }
}
