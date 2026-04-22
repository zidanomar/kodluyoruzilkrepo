import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Doğum Yılınızı Giriniz: ");
        int year = scanner.nextInt();

        String[] zodiac = {"Maymun", "Horoz", "Köpek", "Domuz", "Fare", "Öküz",
                           "Kaplan", "Tavşan", "Ejderha", "Yılan", "At", "Koyun"};

        System.out.println("Çin Zodyağı Burcunuz: " + zodiac[year % 12]);
        scanner.close();
    }
}
