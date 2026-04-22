import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[][] mineMap;
    static String[][] playerMap;
    static int rows, cols, mineCount;

    static void initGame() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                mineMap[i][j] = "-";
                playerMap[i][j] = "-";
            }

        Random rand = new Random();
        int placed = 0;
        while (placed < mineCount) {
            int r = rand.nextInt(rows), c = rand.nextInt(cols);
            if (!mineMap[r][c].equals("*")) { mineMap[r][c] = "*"; placed++; }
        }
    }

    static void printMap(String[][] map) {
        for (String[] row : map) {
            for (String cell : row) System.out.print(cell + " ");
            System.out.println();
        }
    }

    static int countAdjacentMines(int r, int c) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++)
            for (int dc = -1; dc <= 1; dc++) {
                int nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && mineMap[nr][nc].equals("*"))
                    count++;
            }
        return count;
    }

    static boolean isWin() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (playerMap[i][j].equals("-") && !mineMap[i][j].equals("*")) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Satır sayısını giriniz (min 2): ");
            rows = input.nextInt();
            System.out.print("Sütun sayısını giriniz (min 2): ");
            cols = input.nextInt();
            if (rows < 2 || cols < 2) System.out.println("Minimum 2x2 boyutunda matris giriniz!");
        } while (rows < 2 || cols < 2);

        mineCount = (rows * cols) / 4;
        mineMap = new String[rows][cols];
        playerMap = new String[rows][cols];
        initGame();

        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz!");
        System.out.println("===========================");

        while (true) {
            printMap(playerMap);
            int r, c;
            while (true) {
                System.out.print("Satır Giriniz: ");
                r = input.nextInt();
                System.out.print("Sütun Giriniz: ");
                c = input.nextInt();
                if (r < 0 || r >= rows || c < 0 || c >= cols)
                    System.out.println("Geçersiz koordinat, tekrar giriniz.");
                else if (!playerMap[r][c].equals("-"))
                    System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin.");
                else break;
            }

            if (mineMap[r][c].equals("*")) {
                System.out.println("Game Over!!");
                System.out.println("===========================");
                break;
            }

            playerMap[r][c] = String.valueOf(countAdjacentMines(r, c));

            if (isWin()) {
                System.out.println("Oyunu Kazandınız!");
                printMap(playerMap);
                System.out.println("===========================");
                break;
            }
            System.out.println("===========================");
        }
        input.close();
    }
}
