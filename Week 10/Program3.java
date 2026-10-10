import java.util.Scanner;

public class Program3 {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;
        if (k == 0) return names;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();
        int k = sc.nextInt();
        String[] rotated = rotateRoster(names, k);
        System.out.println("[" + String.join(", ", rotated) + "]");
    }
}
