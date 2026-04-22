import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sıcaklığı giriniz (°C): ");
        double temp = scanner.nextDouble();

        if (temp < 5) {
            System.out.println("Öneri: Kayak");
        } else if (temp < 15) {
            System.out.println("Öneri: Sinema");
        } else if (temp < 25) {
            System.out.println("Öneri: Piknik");
        } else {
            System.out.println("Öneri: Yüzme");
        }

        // Ödev: Ternary zinciri ile alternatif çözüm
        String activity = temp < 5 ? "Kayak" : temp < 15 ? "Sinema" : temp < 25 ? "Piknik" : "Yüzme";
        System.out.println("(Ternary) Öneri: " + activity);
        scanner.close();
    }
}
