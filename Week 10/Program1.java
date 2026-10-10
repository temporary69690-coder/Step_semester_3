import java.util.Scanner;

public class Program1 {
    public static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s > second && s != highest) {
                second = s;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        System.out.println(secondHighest(scores));
    }
}
