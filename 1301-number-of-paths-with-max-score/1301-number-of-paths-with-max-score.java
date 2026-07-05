class Solution {

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m = board.get(0).length();
        
        int[][] sums = new int[n][m];
        int[][] ways = new int[n][m];

        sums[n-1][m-1] = 0;
        ways[n-1][m-1] = 1;
        for(int j=m-2;j>=0;j--) {
            if(board.get(n-1).charAt(j) == 'X') {
                sums[n-1][j]=0;
                ways[n-1][j]=0;
                continue;
            } else if (ways[n-1][j+1] == 0) {
                continue;
            } 
            sums[n-1][j] = sums[n-1][j+1] + board.get(n-1).charAt(j) - '0';
            ways[n-1][j] = 1;
        }
        for(int i=n-2;i>=0;i--) {
            if(board.get(i).charAt(m-1) == 'X') {
                sums[i][m-1]=0;
                ways[i][m-1]=0;
                continue;
            } else if (ways[i+1][m-1] == 0) {
                continue;
            } 
            sums[i][m-1] = sums[i+1][m-1] + board.get(i).charAt(m-1) - '0';
            ways[i][m-1] = 1;
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=m-2;j>=0;j--) {
                if(board.get(i).charAt(j) == 'X' || (ways[i+1][j] == 0 && ways[i][j+1] == 0 && ways[i+1][j+1] == 0)) {
                    sums[i][j]=0;
                    ways[i][j]=0;
                    continue;
                }
                int fromDown = sums[i+1][j];
                int fromRight = sums[i][j+1];
                int fromCross = sums[i+1][j+1];
                int max = getMax(fromDown, fromRight, fromCross);

                sums[i][j] = max + (i==0 && j==0 ? 0 : board.get(i).charAt(j)-'0');

                if(max == fromDown) {
                    ways[i][j] = (ways[i][j] + ways[i+1][j])%1000000007;
                }
                if(max == fromRight) {
                    ways[i][j] = (ways[i][j] + ways[i][j+1])%1000000007;
                }
                if(max == fromCross) {
                    ways[i][j] = (ways[i][j] + ways[i+1][j+1])%1000000007;
                }
            }
        }
        return new int[]{sums[0][0], ways[0][0]};
    }
    private int getMax(int... a) {
        int max = 0;
        for(int x: a) {
            if(x > max) {
                max=x;
            }
        }
        return max;
    }
}