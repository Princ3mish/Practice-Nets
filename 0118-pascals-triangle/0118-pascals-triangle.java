class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                } else {
                    List<Integer> prevRow = triangle.get(i - 1);
                    rows.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            triangle.add(rows);
        }

        return triangle;
    }
}