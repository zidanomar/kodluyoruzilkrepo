import java.util.Scanner;

public class Main {
    static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kelimeyi giriniz: ");
        String word = scanner.nextLine();
        System.out.println(word + (isPalindrome(word) ? " palindromik bir kelimedir." : " palindromik değildir."));
        scanner.close();
    }
}
