import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String correctPassword = "patika123";

        System.out.print("Şifrenizi giriniz: ");
        String password = scanner.nextLine();

        if (password.equals(correctPassword)) {
            System.out.println("Giriş başarılı!");
        } else {
            System.out.println("Şifre yanlış!");
            System.out.print("Şifrenizi sıfırlamak ister misiniz? (evet/hayır): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("evet")) {
                System.out.print("Yeni şifrenizi giriniz: ");
                String newPassword = scanner.nextLine();
                if (newPassword.equals(correctPassword)) {
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                } else {
                    System.out.println("Şifre oluşturuldu.");
                }
            }
        }
        scanner.close();
    }
}
