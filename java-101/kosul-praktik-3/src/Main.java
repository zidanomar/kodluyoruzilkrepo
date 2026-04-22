import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dersler = {"Matematik", "Fizik", "Türkçe", "Kimya", "Müzik"};
        double toplamNot = 0;
        int gecerliDersSayisi = 0;

        for (String ders : dersler) {
            System.out.print(ders + " notu: ");
            double not = scanner.nextDouble();
            if (not >= 0 && not <= 100) {
                toplamNot += not;
                gecerliDersSayisi++;
            } else {
                System.out.println("Geçersiz not, ortalamaya katılmıyor.");
            }
        }

        if (gecerliDersSayisi == 0) {
            System.out.println("Geçerli not girişi yapılmadı.");
        } else {
            double ortalama = toplamNot / gecerliDersSayisi;
            System.out.println("Ortalama: " + ortalama);
            System.out.println(ortalama >= 55 ? "Geçti" : "Kaldı");
        }
        scanner.close();
    }
}
