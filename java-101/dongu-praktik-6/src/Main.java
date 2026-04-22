import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı Giriniz: ");
        int number = scanner.nextInt();

        int tempNumber = number, basNumber = 0, result = 0;
        while (tempNumber != 0) { tempNumber /= 10; basNumber++; }

        tempNumber = number;
        while (tempNumber != 0) {
            int basValue = tempNumber % 10;
            int basPow = 1;
            for (int i = 1; i <= basNumber; i++) basPow *= basValue;
            result += basPow;
            tempNumber /= 10;
        }

        System.out.println(number + (result == number ? " sayısı bir Armstrong sayıdır." : " sayısı bir Armstrong sayısı değildir."));

        System.out.println("\n--- Ödev: Basamak Toplamı ---");
        System.out.print("Sayı giriniz: ");
        int n = scanner.nextInt();
        int digitSum = 0;
        int temp = Math.abs(n);
        while (temp != 0) { digitSum += temp % 10; temp /= 10; }
        System.out.println("Basamak toplamı: " + digitSum);
        scanner.close();
    }
}
