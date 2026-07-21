public class mazePath {

    public static void printPaths(int row, int col, int n, int m, String path) {
        
        // Base case: reached destination
        if (row == n - 1 && col == m - 1) {
            System.out.println(path);
            return;
        }

        // Move Down
        if (row < n - 1) {
            printPaths(row + 1, col, n, m, path + "D");
        }

        // Move Right
        if (col < m - 1) {
            printPaths(row, col + 1, n, m, path + "R");
        }
    }

    public static void main(String[] args) {
        int n = 3; // rows
        int m = 3; // columns

        printPaths(0, 0, n, m, "");
    }
}