import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Birinci sayıyı giriniz: ");
        int n1 = scanner.nextInt();
        System.out.print("İkinci sayıyı giriniz: ");
        int n2 = scanner.nextInt();

        // EBOB (for döngüsü)
        int ebob = 1;
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) ebob = i;
        }
        int ekok = (n1 * n2) / ebob;
        System.out.println("EBOB (for): " + ebob);
        System.out.println("EKOK (for): " + ekok);

        // Ödev: while döngüsü ile EBOB
        int a = n1, b = n2;
        while (b != 0) { int temp = b; b = a % b; a = temp; }
        ebob = a;
        ekok = (n1 * n2) / ebob;
        System.out.println("EBOB (while/Öklid): " + ebob);
        System.out.println("EKOK (while/Öklid): " + ekok);
        scanner.close();
    }
}
