import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Birinci sayıyı giriniz: ");
        double num1 = scanner.nextDouble();
        System.out.print("İşlemi giriniz (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.print("İkinci sayıyı giriniz: ");
        double num2 = scanner.nextDouble();

        switch (op) {
            case '+': System.out.println("Sonuç: " + (num1 + num2)); break;
            case '-': System.out.println("Sonuç: " + (num1 - num2)); break;
            case '*': System.out.println("Sonuç: " + (num1 * num2)); break;
            case '/':
                if (num2 == 0) System.out.println("Sıfıra bölme hatası!");
                else System.out.println("Sonuç: " + (num1 / num2));
                break;
            default: System.out.println("Geçersiz işlem!");
        }
        scanner.close();
    }
}
