import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fibonacci serisi eleman sayısını giriniz: ");
        int n = scanner.nextInt();

        long a = 0, b = 1;
        System.out.print("Fibonacci Serisi: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            long temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
        scanner.close();
    }
}
