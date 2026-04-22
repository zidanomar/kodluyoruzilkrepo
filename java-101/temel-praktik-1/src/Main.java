import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Matematik puanını giriniz: ");
        double matematik = scanner.nextDouble();
        System.out.print("Fizik puanını giriniz: ");
        double fizik = scanner.nextDouble();
        System.out.print("Kimya puanını giriniz: ");
        double kimya = scanner.nextDouble();
        System.out.print("Türkçe puanını giriniz: ");
        double turkce = scanner.nextDouble();
        System.out.print("Tarih puanını giriniz: ");
        double tarih = scanner.nextDouble();
        System.out.print("Müzik puanını giriniz: ");
        double muzik = scanner.nextDouble();

        double ortalama = (matematik + fizik + kimya + turkce + tarih + muzik) / 6;
        System.out.println("Ortalamanız: " + ortalama);

        String sonuc = ortalama > 60 ? "Sınıfı Geçti" : "Sınıfta Kaldı";
        System.out.println(sonuc);

        scanner.close();
    }
}
