class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for (int i = 0; i < m; i++) {
            boolean moved = true;
            while (moved) {
                moved = false;
                for (int j = n - 2; j >= 0; j--) {
                    if (boxGrid[i][j] == '#' && boxGrid[i][j + 1] == '.') {
                        boxGrid[i][j] = '.';
                        boxGrid[i][j + 1] = '#';
                        moved = true;
                    }
                }
            }
        }

        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return rotatedBox;
    }
}