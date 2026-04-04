class Solution {
    public String decodeCiphertext(String encodedText, int rows) {

        if (rows == 0) return "";

        int n = encodedText.length();
        int cols = n / rows;

        char[][] grid = new char[rows][cols];

        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = encodedText.charAt(index++);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {

            int i = 0;      
            int j = col;    

            while (i < rows && j < cols) {
                result.append(grid[i][j]);
                i++;
                j++;
            }
        }

        
        int end = result.length() - 1;

        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}