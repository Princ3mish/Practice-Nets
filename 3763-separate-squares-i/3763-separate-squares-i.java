class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        double minY = Double.POSITIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        double total = 0.0;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y + l);
            total += l * l;
        }

        double target = total / 2.0;
        double lo = minY, hi = maxY;

        
        for (int iter = 0; iter < 100; iter++) {
            double mid = (lo + hi) / 2.0;
            double below = areaBelow(squares, mid);
            if (below >= target) hi = mid;
            else lo = mid;
        }

        return hi;
    }

    private double areaBelow(int[][] squares, double y) {
        double sum = 0.0;
        for (int[] s : squares) {
            double bottom = s[1];
            double len = s[2];
            double h;
            if (y <= bottom) h = 0.0;
            else if (y >= bottom + len) h = len;
            else h = y - bottom;
            sum += len * h;
        }
        return sum;
    }
}
