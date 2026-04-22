import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Matematik puanini giriniz: ");
        double matematik = scanner.nextDouble();

        System.out.print("Fizik puanini giriniz: ");
        double fizik = scanner.nextDouble();

        System.out.print("Kimya puanini giriniz: ");
        double kimya = scanner.nextDouble();

        System.out.print("Turkce puanini giriniz: ");
        double turkce = scanner.nextDouble();

        System.out.print("Tarih puanini giriniz: ");
        double tarih = scanner.nextDouble();

        System.out.print("Muzik puanini giriniz: ");
        double muzik = scanner.nextDouble();

        double ortalama = (matematik + fizik + kimya + turkce + tarih + muzik) / 6;

        System.out.println("Ortalamaniz: " + ortalama);

        String sonuc = ortalama > 60 ? "Sinifi Gecti" : "Sinifta Kaldi";
        System.out.println(sonuc);

        scanner.close();
    }
}
