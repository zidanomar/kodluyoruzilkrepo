import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);
        Scanner input = new Scanner(System.in);
        int right = 0, selected;
        int[] wrong = new int[5];
        boolean isWin = false, isWrong = false;

        while (right < 5) {
            System.out.print("Lütfen tahmininizi giriniz (0-99): ");
            selected = input.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("Lütfen 0-99 arasında bir değer giriniz.");
                if (isWrong) {
                    right++;
                    System.out.println("Kalan hak: " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }

            if (selected == number) {
                System.out.println("Tebrikler, doğru tahmin! Sayı: " + number);
                isWin = true;
                break;
            } else {
                System.out.println(selected > number ? "Büyük!" : "Küçük!");
                wrong[right++] = selected;
                System.out.println("Kalan hak: " + (5 - right));
            }
        }

        if (!isWin) {
            System.out.println("Kaybettiniz! Gizli sayı: " + number);
            System.out.println("Tahminleriniz: " + Arrays.toString(wrong));
        }
        input.close();
    }
}
