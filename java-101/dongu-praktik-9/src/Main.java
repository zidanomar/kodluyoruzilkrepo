import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int right = 3, balance = 1500;

        while (right > 0) {
            System.out.print("Kullanıcı Adınız: ");
            String userName = input.nextLine();
            System.out.print("Parolanız: ");
            String password = input.nextLine();

            if (userName.equals("patika") && password.equals("dev123")) {
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");
                int select;
                do {
                    System.out.println("1-Para Yatırma\n2-Para Çekme\n3-Bakiye Sorgula\n4-Çıkış Yap");
                    System.out.print("İşlem seçiniz: ");
                    select = input.nextInt();
                    input.nextLine();
                    switch (select) {
                        case 1:
                            System.out.print("Miktar: ");
                            balance += input.nextInt(); input.nextLine();
                            break;
                        case 2:
                            System.out.print("Miktar: ");
                            int amount = input.nextInt(); input.nextLine();
                            if (amount > balance) System.out.println("Bakiye yetersiz.");
                            else balance -= amount;
                            break;
                        case 3:
                            System.out.println("Bakiyeniz: " + balance);
                            break;
                    }
                } while (select != 4);
                System.out.println("Tekrar görüşmek üzere.");
                break;
            } else {
                right--;
                System.out.println("Hatalı giriş. Kalan hakkınız: " + right);
                if (right == 0) System.out.println("Hesabınız bloke olmuştur.");
            }
        }
        input.close();
    }
}
