import java.util.PriorityQueue;

class Solution {
    class Cell {
        int row;
        int col;
        int height;
        
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int totalWater = 0;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Cell current = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = current.row + dRow[i];
                int nCol = current.col + dCol[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;

                    if (heightMap[nRow][nCol] < current.height) {
                        totalWater += current.height - heightMap[nRow][nCol];
                    }

                    pq.offer(new Cell(nRow, nCol, Math.max(heightMap[nRow][nCol], current.height)));
                }
            }
        }

        return totalWater;
    }
}