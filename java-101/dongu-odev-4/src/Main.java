public class Main {
    public static void main(String[] args) {
        System.out.print("1-100 arası asal sayılar: ");
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) { isPrime = false; break; }
            }
            if (isPrime) System.out.print(i + " ");
        }
        System.out.println();
    }
}
