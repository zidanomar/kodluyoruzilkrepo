import java.util.Scanner;

public class Main {
    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Faktöriyeli hesaplanacak sayıyı giriniz: ");
        int n = scanner.nextInt();
        System.out.println(n + "! = " + factorial(n));

        System.out.println("\n--- Ödev: Kombinasyon C(n,r) = n! / (r! * (n-r)!) ---");
        System.out.print("n: ");
        int cn = scanner.nextInt();
        System.out.print("r: ");
        int cr = scanner.nextInt();
        long combination = factorial(cn) / (factorial(cr) * factorial(cn - cr));
        System.out.println("C(" + cn + "," + cr + ") = " + combination);
        scanner.close();
    }
}
