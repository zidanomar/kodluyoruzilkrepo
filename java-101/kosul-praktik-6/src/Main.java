import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ayınızı giriniz (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Gününüzü giriniz: ");
        int day = scanner.nextInt();

        int code = month * 100 + day;
        String sign;

        if      (code >= 321 && code <= 420) sign = "Koç";
        else if (code >= 421 && code <= 521) sign = "Boğa";
        else if (code >= 522 && code <= 622) sign = "İkizler";
        else if (code >= 623 && code <= 722) sign = "Yengeç";
        else if (code >= 723 && code <= 822) sign = "Aslan";
        else if (code >= 823 && code <= 922) sign = "Başak";
        else if (code >= 923 && code <= 1022) sign = "Terazi";
        else if (code >= 1023 && code <= 1121) sign = "Akrep";
        else if (code >= 1122 && code <= 1221) sign = "Yay";
        else if (code >= 1222 || code <= 121) sign = "Oğlak";
        else if (code >= 122 && code <= 219) sign = "Kova";
        else sign = "Balık";

        System.out.println("Burcunuz: " + sign);
        scanner.close();
    }
}
