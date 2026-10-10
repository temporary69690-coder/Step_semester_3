import java.util.Scanner;

public class Program4 {
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = 0;
        for (int i = 0; i < grid.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < grid[i].length; j++) rowSum += grid[i][j];
            if (rowSum > bestTotal) {
                bestTotal = rowSum;
                bestRow = i;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = sc.nextInt();
        int[] result = busiestRow(grid);
        System.out.printf("Row %d, Total %d%n", result[0], result[1]);
    }
}
