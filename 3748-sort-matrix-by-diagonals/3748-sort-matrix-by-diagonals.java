class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diagonals = new HashMap<>();

        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                diagonals.computeIfAbsent(i - j, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        
        for (var entry : diagonals.entrySet()) {
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            if (key >= 0) {
                list.sort(Collections.reverseOrder()); 
            } else {
                Collections.sort(list); 
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> list = diagonals.get(key);
                grid[i][j] = list.remove(0);
            }
        }
        return grid;
    }
}
