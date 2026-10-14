public class BusiestRow {
    public static void busiestRow(int[][] grid) {
        int maxTotal = -1;
        int rowIndex = -1;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
            if (sum > maxTotal) {
                maxTotal = sum;
                rowIndex = i;
            }
        }

        System.out.println("Row " + rowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        busiestRow(grid); // Row 1, Total 7
    }
}
