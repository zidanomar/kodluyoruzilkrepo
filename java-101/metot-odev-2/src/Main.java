public class Main {
    static int countFrequency(int[] arr, int target) {
        int count = 0;
        for (int val : arr) if (val == target) count++;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 10, 20, 5, 20};
        System.out.println("Dizi: java.util.Arrays.toString(arr)");
        System.out.println("Tekrar Sayıları:");

        boolean[] counted = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (counted[i]) continue;
            int freq = countFrequency(arr, arr[i]);
            System.out.println(arr[i] + " sayısı " + freq + " kere tekrar edildi.");
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == arr[i]) counted[j] = true;
            }
        }
    }
}
