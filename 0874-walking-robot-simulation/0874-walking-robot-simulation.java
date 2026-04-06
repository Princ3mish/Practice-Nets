import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int dir = 0;
        int x = 0, y = 0;

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int maxDistance = 0;

        for (int cmd : commands) {

            if (cmd == -1) {
                dir = (dir + 1) % 4;
            } 
            else if (cmd == -2) {
                dir = (dir + 3) % 4;
            } 
            else {
                for (int step = 0; step < cmd; step++) {

                    int newX = x + dirs[dir][0];
                    int newY = y + dirs[dir][1];

                    if (obstacleSet.contains(newX + "," + newY)) {
                        break;
                    }

                    x = newX;
                    y = newY;

                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }
}