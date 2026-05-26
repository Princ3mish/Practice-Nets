class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int r = 0 ; r < 9 ; r++){
            for(int c = 0 ; c < 9 ; c++){
                char num = board[r][c];
                if(num != '.'){
                    String rcheck = "r" + r + num;
                    String ccheck = "c" + c + num;
                    String bcheck = "b" + r/3 + c/3 + num;
                    if(!seen.add(rcheck) || !seen.add(ccheck)|| !seen.add(bcheck)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}